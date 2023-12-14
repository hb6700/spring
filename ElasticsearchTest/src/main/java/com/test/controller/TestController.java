package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	//목록보기
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/list.do")
	public String list(Model model, String type, String word, String word2, 
						@RequestParam(defaultValue="0") int slop) {
	
		if (type == null || type.equals("")) {
			//전체 검색
			type = "match_all";
		}
		
		try {
			// 엘라스틱서치 호스트 정보 설정
			//HttpHost host = new HttpHost("엘라스틱서치 IP", "포트번호", "프로토콜");
			HttpHost host = new HttpHost("localhost", 9200, "http");
			
			//엘라스틱서치 연결정보를가지고 있는 친구(객체)
			// RestClientBuilder를 사용하여 RestHighLevelClient 생성
			//RestClientBuilder builder = RestClient.builder("엘라스틱서치 IP 주소");
			RestClientBuilder builder = RestClient.builder(host);
			
			RestHighLevelClient client = new RestHighLevelClient(builder);
			
			//접근하려는 인덱스 참조 -> spring 인덱스
			// 검색을 수행할 인덱스 지정 (예: "spring" 인덱스)
			SearchRequest searchRequest = new SearchRequest("spring");
			
			// 검색 요청 구성
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);
			
			//**엘라스틱서치 검색기능
			// 엘라스틱서치 쿼리를 생성하여 설정 (예: match_all 쿼리)
			/*
			GET spring/_search
			{
				"query" : {
					"match_all" : {}
				}
			}
			*/
			
			if(type.equals("match_all")) {
				//match all
				searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			}else if(type.equals("match_or")) {
				//match > 풀텍스트 검색
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word));
			}else if(type.equals("match_and")) {
				//match + operator(and)
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word).operator(Operator.AND));
			}else if(type.equals("match_phrase")) {
				//match phrase
				if (slop == 0) {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word));
				} else {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word).slop(slop));
				}
			}else if(type.equals("match_bool")) {
				searchSourceBuilder.query(QueryBuilders.boolQuery()
									.must(QueryBuilders.matchQuery("message", word))
									.mustNot(QueryBuilders.matchQuery("message", word2)));
			}else if(type.equals("match_should")) {
				searchSourceBuilder.query(QueryBuilders.boolQuery()
						.must(QueryBuilders.matchQuery("message", word))
						.should(QueryBuilders.matchQuery("message", word)));
			}
			
			// 검색 요청에 설정된 검색 소스 추가
			searchRequest.source(searchSourceBuilder);
			
			//실제 검색 요청
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			
			// 검색 결과에서 검색된 문서들에 대한 정보 가져오기
			SearchHits searchHits = searchResponse.getHits();
			
			// 검색된 문서들에 대한 정보를 반복하여 출력
			for(SearchHit hit : searchHits) { 
				System.out.println(hit);
			}
			
			//SearchHits > 변환 > List<HashMap>
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for(SearchHit hit : searchHits) {
				//Document > HashMap
				Map<String, Object> map = hit.getSourceAsMap();
				map.put("id", hit.getId());
				map.put("score", hit.getScore());
				list.add(map);
			}
			
			model.addAttribute("list", list);
			model.addAttribute("word", word);
			model.addAttribute("type", type);
			model.addAttribute("slop", slop);
			
			
			//사용종료 > 엘라스틱설치 접속 종료
			// 클라이언트 사용 종료 및 리소스 반환
			client.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	//추가하기(폼)
	@GetMapping(value = "/add.do")
	public String add(Model model) {
		return "add";
	}
	
	//추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model, String id, String message) {
		
		try {
			//client 객체
			RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("172.31.40.145", 9200, "http")));
			/*
			 PUT spring/_doc/11
			 {
			 	"message": "안녕하세요. 홍길동입니다."
			 }
			*/
			String data = String.format("{\"message\": \"%s\"}", message);
			
			IndexRequest indexRequest = new IndexRequest("spring").source(data, XContentType.JSON).setRefreshPolicy("wait_for");
			
			indexRequest.id(id);
			
			//전송
			//실제로 엘리스틱서치에 데이터(도큐먼트)를 추가하기
			client.index(indexRequest, RequestOptions.DEFAULT);
			
			client.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/list.do";
	}
	
}

package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용


//public class Ex03Controller implements Controller{
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
//		
//		return null;
//		
//	}
//
//}


@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller{
	
	//요청메서드(doGet/doPost/handleRequest) -> 맘대로
	//==요청을 처리하는 메소드를 지정(핸들러) -> 어노테이션 필요
	@RequestMapping
	public String test() {
		//업무 코드
		//JSP 호출하기 > ModelAndView
		
		//1. ModelAndView 동작
		//2. ViewResolver 동작
		
		//RequestDispacher dispatcher = req.get~~("WEB-INF/~~~");
		return "ex03";
	}
	
	//@RequestMapping
	public int sum(int a, int b) {
		return a+b;
	}
	
}
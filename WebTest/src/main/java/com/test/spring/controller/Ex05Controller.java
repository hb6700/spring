package com.test.spring.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.spring.domain.SpringDTO;
import com.test.spring.persistence.SpringDAO;
import com.test.spring.persistence.SpringDAOImpl;

@Controller
public class Ex05Controller {
	
//	@RequestMapping(value="/ex05.do", method=RequestMethod.GET)
	@GetMapping(value="/ex05.do")
	 public String ex05() {
		//데이터 입력 폼 
		 return "ex05";
	 }
	
	//ver1.
//	@RequestMapping(value="/ex05ok.do", method=RequestMethod.POST)
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
//		
//		//데이터 수신
//		//servlet/JSP : req.getParameter(), req.getParameterValues()
//		
//		//System.out.println(req == null);
//		//System.out.println(resp == null);
//		//System.out.println(session == null);
//
//		String data = req.getParameter("data");
//		req.setAttribute("data", data);
//		
//		return "ex05ok";
//	}
	
	
	//ver2.
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(@RequestParam(name="data") String data, Model model) {
//		
//		//<input type="text" name="data">
//		
//		//String data = req.getParameter("data"); + @requestParam~~
//		System.out.println(data);
//		
//		//req.setAttribute("data", data)
//		model.addAttribute("data", data);
//		
//		return "ex05ok";
//	}
	
	
	//ver3.
	//@getParam 쓰지 않고도  사용하는 방법은 매개변수명 맞춰줘야만 사용이 가능
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(String data, Model model) {
//		
//		model.addAttribute("data", data);
//		return "ex05ok";
//	}
	
	
	//ver4.
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(@RequestParam("name") String name, @RequestParam String age, @RequestParam String address, Model model) {
//
//		SpringDTO dto = new SpringDTO();
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		SpringDAO dao = new SpringDAOImpl();
//		int result = dao.add(dto);
//		model.addAttribute("result", result);
//		return "ex05ok";
//		
//	}
	
	
	//ver5.
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(String name, String age, String address, Model model) {
//
//		SpringDTO dto = new SpringDTO();
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		SpringDAO dao = new SpringDAOImpl();
//		int result = dao.add(dto);
//		model.addAttribute("result", result);
//		return "ex05ok";
//		
//	}
	
	
	//ver6
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(SpringDTO dto, String seq, Model model) {
//
//		SpringDAO dao = new SpringDAOImpl();
//		int result = dao.add(dto);
//		System.out.println(seq);
//		model.addAttribute("result", result);
//		return "ex05ok";
//		
//	}
	
	
	//ver7.
//	@PostMapping(value="/ex05ok.do")
//	public String ex05ok(Model model, HttpServletRequest req) {
//		String[] cb = req.getParameterValues("cb");
//		System.out.println(Arrays.toString(cb));
//		return "ex05ok";
//	}
	
	
	//ver8.
//	@PostMapping(value="/ex05ok.do")
//						//@RequestParam("cb") String[] cb
//	public String ex05ok(Model model, String[] cb) {
//		System.out.println(Arrays.toString(cb));
//		return "ex05ok";
//	}

	
	//ver9. : ver3비교
	@PostMapping(value="/ex05ok.do")
	public String ex05ok(@ModelAttribute(name="data") String data) {
		return "ex05ok";
	}
	
	
	
	
	
}

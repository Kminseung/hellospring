package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// 요청을 받아야 함
	// url 패턴 /hello에 반응
	// 파라미터로 name을 받음
	// 예: /hello?name=홍길동
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam String name) {
		// Spring의 기본 응답 객체는 ModelAndView
		// 데이터(Model)와 뷰객체의 정보를 함께 가지고 있음.
		ModelAndView mav = new ModelAndView();
		
		// 데이터 설정
		mav.addObject("message", "Hello, " + name);	// Servlet에서 attribute 추가와 비슷
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
}

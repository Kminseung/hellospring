package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hellospring.Vo.RequestVo;

// 파라미터 관련 내용 정리
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	@RequestMapping({"", "/"})		// 여러 URL 패턴에 응답
	// 파라미터 기본 값 에제
	// 기본 방식으로 RequestParma을 사용하면 반드시 파라미터가 전달되어야 함
	// public ModelAndView home(@RequestParam String name) {
	public ModelAndView home(@RequestParam(value="name", required=false, defaultValue="there") String name) {
		// required=false, defaultValue 를 부여해서 파라미터 기본 값을 부여
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello, " + name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	
	// Path Variable
	// 파라미터를 URL 쿼리 스트링(EX: ?name=___&no=___)으로 전달하지 않고
	// URL 경로상에 지정하는 방법(=Fancy URL, Pretty URL)
	//	{} -> URL 경로상의 내용을 파라미터로 변환
	@RequestMapping("/pathparam/{name}/{no}")
	public ModelAndView pathParam(@PathVariable String name, @PathVariable Long no)  {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name: " + name + ", No: " + no);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	
	// 요청 파라미터를 객체에 담아 전달하기 
	@RequestMapping("/using-vo")
	public ModelAndView usingVo(@ModelAttribute RequestVo vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name: " + vo.getName() + ", No: " + vo.getNo());
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	
	// Return Type이 String이면 ViewName 전달
	@RequestMapping("/rstr")
	public String returnString() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	// ModelAndView를 사용하지 않고 String을 리터하지만
	// Model을 사용해야 할 경우
	// 메서드 인자값으로 Model을 받아올 수 있고 -> 사용 가능
	@RequestMapping("/rstr2")
	public String returnString2(ModelMap map) {
		// 필요한 객체를 메서드 인자로 요청하면
		// String이 필요 객체를 전달해 줌
		// ex) HTTPRequest, HTTPResponse, HTTPSession 등
		map.addAttribute("message", "모델 데이터");
		return "/WEB-INF/views/hello.jsp";
	}
}

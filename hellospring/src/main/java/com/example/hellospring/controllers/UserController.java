package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hellospring.Vo.UserVo;

// RequestMapping(Type + Method 매핑)
@RequestMapping("/user")	// /usr url 패턴에 응답
@Controller
public class UserController {
	@RequestMapping("joinform")		// /user/joinform 패턴에 응답
	public String joinform() {
		// ViewName 리턴
		return "/WEB-INF/views/joinform.jsp";
	}
	
	// 파라미터를 다수를 받아야할 경우 -> VO를 사용하는 것이 좋음
	// 자동 동적 바인딩을 위해 ModelAttribute 사용
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("Model Attribute:" + vo);
		
		return "redirect:/user/joinsuccess";
	}
	
//	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(@RequestParam String name, @RequestParam String email,
//						@RequestParam String password, @RequestParam String gender,
//						@RequestParam int age) {
//		System.out.println("Param name: " + name);
//		System.out.println("Param email: " + email);
//		System.out.println("Param password: " + password);
//		System.out.println("Param gender: " + gender);
//		System.out.println("Param age: " + age);
//		
//		return "redirect:/user/joinsuccess";	// REDIRECT
//	}
	
	@ResponseBody
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "<h3>Join Success!</h3>";
	}
}

package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// RequestMapping(Type + Method 매핑)
@RequestMapping("/user")	// /usr url 패턴에 응답
@Controller
public class UserController {
	@RequestMapping("joinform")		// /user/joinform 패턴에 응답
	public String joinform() {
		// ViewName 리턴
		return "/WEB-INF/views/joinform.jsp";
	}
}

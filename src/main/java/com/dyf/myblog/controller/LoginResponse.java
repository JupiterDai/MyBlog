package com.dyf.myblog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyf.myblog.common.base.AjaxResponseBody;
import com.dyf.myblog.entity.UserInfo;

@Controller
public class LoginResponse {
	@GetMapping("/web/login")
	public String loginPage() {
		return "html/Login.html";

	}
	
	@PostMapping("/web/login")
	@ResponseBody
	public String logoin(UserInfo webuser, HttpServletRequest request) {
		System.out.print(webuser.getUsername());
		
		return "success";

	}
}

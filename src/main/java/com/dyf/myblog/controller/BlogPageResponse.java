package com.dyf.myblog.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogPageResponse{
	@GetMapping("/web/BlogPage")
	public String blogPage() {
		return "html/BlogPage.html";
	}
}

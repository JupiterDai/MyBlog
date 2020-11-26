package com.dyf.myblog.controller;

import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyf.myblog.DAO.UserInfoDao;
import com.dyf.myblog.common.base.AjaxResponseBody;
import com.dyf.myblog.common.utils.SpringUtils;
import com.dyf.myblog.entity.UserInfo;
import com.sun.jdi.connect.spi.Connection;



@Controller
public class LoginResponse {
	@GetMapping("/web/login")
	public String loginPage() {
		return "html/Login.html";

	}
	
	@PostMapping("/web/login")
	@ResponseBody
	public String logoin(UserInfo webuser, HttpServletRequest request) {
		UserInfoDao dao = SpringUtils.getBean(UserInfoDao.class);
		UserInfo info = dao.getUsername(webuser.getUsername());
		if (info!=null&&info.getPassword().equals(webuser.getPassword())) {
			return "success";
		} else {
			return "fail";
		}

	
}
	}

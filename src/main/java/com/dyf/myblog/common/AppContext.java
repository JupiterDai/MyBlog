package com.dyf.myblog.common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AppContext implements Serializable {
	private String userName;
	public static final String APP_CONTEXT_KEY = "Legion_Web_Session_Context";
	private static final ThreadLocal<AppContext> localContext = new ThreadLocal<>();

	public static AppContext getFromWebThread() {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return (AppContext) requestAttributes.getRequest().getSession().getAttribute(APP_CONTEXT_KEY);
	}

	public static AppContext getAppContext(HttpServletRequest request) {
		if (request != null) {
			Object obj = request.getSession().getAttribute(APP_CONTEXT_KEY);
			if (obj != null) {
				return (AppContext) obj;
			}
		}
		return null;
	}

	public void setAppContext() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		requestAttributes.getRequest().getSession().setAttribute(APP_CONTEXT_KEY, this);
	}

	public void setAppContext(HttpServletRequest request) {
		if (request != null) {
			request.getSession().setAttribute(APP_CONTEXT_KEY, this);
		}
	}

	public void setLocalAppContext() {
		localContext.set(this);
	}

	public AppContext getLocalAppContext() {
		return localContext.get();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

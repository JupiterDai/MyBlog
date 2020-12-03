package com.dyf.myblog.common.webmvc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.dyf.myblog.common.AppContext;
import com.dyf.myblog.common.utils.SpringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object context = session.getAttribute(AppContext.APP_CONTEXT_KEY);
        if (context != null) {
            return true;
        } else {
                response.sendRedirect("/web/login");
                log.warn("Intercepted requests: " + request.getRequestURL());
                return false;
         }
		
    }

}

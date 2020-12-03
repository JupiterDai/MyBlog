package com.dyf.myblog.common.webmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dyf.myblog.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private GlobalInterceptor globalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	List<String> exculdelList = new ArrayList<>();
    	exculdelList.add("/web/login/**");	
        registry.addInterceptor(globalInterceptor).addPathPatterns("/web/**").excludePathPatterns(exculdelList); 
    }
}
	
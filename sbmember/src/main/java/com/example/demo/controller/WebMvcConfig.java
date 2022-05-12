package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private SessionCheckInter interceptor;

	// 인터셉터가 동작할 url 패턴 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/member_edit.do")
				.addPathPatterns("/member_edit_ok.do")
				.addPathPatterns("/member_del.do")
				.addPathPatterns("/member_del_ok.do")
				.addPathPatterns("/member_logout.do");
	}

}

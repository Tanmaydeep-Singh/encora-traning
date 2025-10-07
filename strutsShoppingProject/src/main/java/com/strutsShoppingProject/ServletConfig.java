package com.strutsShoppingProject;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.strutsShoppingProject.controller.ActionServlet;

@Configuration
public class ServletConfig {
	
	@Bean
	public ServletRegistrationBean<ActionServlet> getActionServlet(){
		ServletRegistrationBean<ActionServlet> srb=new ServletRegistrationBean<>(new ActionServlet(),"*.do");
		srb.setLoadOnStartup(1);
		
		return srb;
	}
}

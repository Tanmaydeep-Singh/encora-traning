package com.strutsShoppingProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;

import com.strutsShoppingProject.controller.ActionServlet;


@SpringBootApplication(scanBasePackages = "com.strutsShoppingProject")
@ServletComponentScan
public class StrutsShoppingProjectApplication {

	public static void main(String[] args) {
		
		try {
			ConfigurableApplicationContext ctx =
					SpringApplication.run(StrutsShoppingProjectApplication.class, args);
			
			ServletRegistrationBean<ActionServlet> srb=(ServletRegistrationBean<ActionServlet>)ctx.getBean("getActionServlet");
			
			ActionServlet as=srb.getServlet();
			
			as.setCtx(ctx);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.strutsShoppingProject.controller;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;

import com.strutsShoppingProject.component.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestProcessor {

	private ConfigurableApplicationContext ctx;
	
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx=ctx;
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			Properties prop=new Properties();
			ServletContext application=request.getServletContext();
			String path=application.getRealPath("/WEB-INF/config.propertie");
			System.out.println("PART "+ path.toString());
			
			prop.load(new FileInputStream(path));
			
			String actionid=request.getParameter("action");
			
			if(actionid==null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				System.out.println("ACTION " +actionid);
				Action action=(Action)ctx.getBean(actionid);
				String result=action.execute(request, response);
				String nextpage=prop.getProperty(result);
				request.getRequestDispatcher(nextpage).forward(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

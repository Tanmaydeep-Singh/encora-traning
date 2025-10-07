package com.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("v1")
public class basicController {
	
	public basicController() {
	System.out.println("called out...");
	}

	@RequestMapping( method = RequestMethod.GET, value = "/")
	public void sayBasicController()
	{
		System.out.println("Bacic controller");
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "/hello")
	public void sayHello()
	{
		System.out.println("Hello");
	}	
	
//	Params
	@RequestMapping( method = RequestMethod.GET, value = "/login")
	public void userLogin(@RequestParam("name")String name, @RequestParam("pass")String pass )
	{
		System.out.println("name " + name +" : pass " + pass);
	}	
	
//	Path Variable
	@RequestMapping( method = RequestMethod.GET, value = "/hello/{msg}")
	public void userMessage(@PathVariable("msg")String msg)
	{
		System.out.println("message: " + msg);
	}
	
	
//	Session creation
	@RequestMapping( method = RequestMethod.GET, value = "/hello2")
	public void hello2(HttpServletRequest req)
	{
		int count = 0;
		HttpSession session = req.getSession();
		System.out.println("SESSTION: " + session.getId());
		
		if(session.getAttribute("count") != null)
		{
			
	        count = (Integer) session.getAttribute("count");			
	        count++;
			session.setAttribute("count", count);
			
		}
		else
		{
			session.setAttribute("count", count);

		}
		
		System.out.println(count);
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "/hello3")
	public void hello3(HttpSession session)
	{
        Integer count = (Integer) session.getAttribute("count");			
		System.out.println(count );
	}
	

}

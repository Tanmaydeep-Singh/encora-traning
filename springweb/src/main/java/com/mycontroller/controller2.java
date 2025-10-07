package com.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("v2")
@SessionAttributes({"mySessionObj"})
public class controller2 {

	@RequestMapping( method = RequestMethod.GET, value = "/basic")
	public String sayHello()
	{
		System.out.println("Called..");
		return "hello";
	}
	
	
	@RequestMapping( method = RequestMethod.GET, value = "/hello")
	public String sayHello(HttpServletRequest request, Model model)
	{
		request.setAttribute("myObjReq", " this is req added values...");
		model.addAttribute("myObj", " this is session value added");
		model.addAttribute("myObj2", " this is session value added 2");
		return "hello";
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "/hello2")
	public String sayHello2(Model model)
	{
//		model.addAttribute("mySessionObj", " this is session value added from hello 2");
		return "hello";
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "/hello3")
	public ModelAndView modelAndView()
	{
		ModelAndView mAndv = new ModelAndView();
		mAndv.addObject("mv", "Model and view " );
		mAndv.setViewName("home");
		return mAndv;
	}

}

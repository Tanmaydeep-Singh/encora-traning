package com.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("user")
public class userController {

	@RequestMapping( method = RequestMethod.GET, value = "/signup")
	public ModelAndView userSignup()
	{
		ModelAndView obj = new ModelAndView();
		User userObj = new User();
		obj.addObject("userObj", userObj);
		obj.setViewName("userSignup");
		return obj;
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/signup")
	public ModelAndView processFrom(
			@Valid
			@ModelAttribute("userObj") User user,
			BindingResult result
			)
	{
		ModelAndView obj = new ModelAndView();
	
		if( result.hasErrors())
		{
			obj.setViewName("userSignup");
			return obj;

		}
		else
		{
			obj.addObject("myUser", user);
			obj.setViewName("welcome");
			return obj;

		}
		
	}
	
	
}

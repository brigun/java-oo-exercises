package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController 
{
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(HttpServletRequest request)
	{
	
		String name = request.getParameter("name");
		
		if(name == null) name = "World";
		
		return "<h1>" + HelloMessage.getMessage(name) + "</h1>";
		
	}

}

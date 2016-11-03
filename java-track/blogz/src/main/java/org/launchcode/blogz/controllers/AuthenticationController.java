package org.launchcode.blogz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController
{

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(HttpServletRequest request)
	{
		if (request != null)return "<h1>login form</h1>";
		else
		{
			return "No request received";
		}
		
	}
	
}

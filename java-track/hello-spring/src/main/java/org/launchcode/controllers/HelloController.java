package org.launchcode.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloLog;
import org.launchcode.models.HelloMessage;
import org.launchcode.models.dao.HelloLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController 
{
	@Autowired
	private HelloLogDao helloLogDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm()
	{
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	
	public String hello(HttpServletRequest request, Model model)
	{
	
		String name = request.getParameter("name");
		String language = request.getParameter("language");
		
		if(name == null || name == "") name = "World";
		
		HelloLog log = new HelloLog(name);
		
		helloLogDao.save(log);
		
		model.addAttribute("message",  HelloMessage.getMessage(name, language));
		
		return "hello";
		
	}
	
	@RequestMapping(value = "/log")
	public String log(Model model)
	{
		List <HelloLog> logs = helloLogDao.findAll();
		
		model.addAttribute("logs", logs);
		return "log";
		
	}

}

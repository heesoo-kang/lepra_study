package com.Bootstrapstudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class mainController {
	
	@RequestMapping(value = {"/event"}, method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		System.out.println("go to main boot");
		return "event";
	}
	@RequestMapping(value = {"/event_main"}, method=RequestMethod.GET)
	public String eventmain(HttpServletRequest request) {
		System.out.println("go to main boot");
		return "event_main";
	}
	
	@RequestMapping(value = {"/index","/exam"}, method=RequestMethod.GET)
	public String boottemp(HttpServletRequest request) {
		System.out.println("go to templete boot");
		return "templete";
	}
	
	@RequestMapping(value = {"/","/login"}, method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		System.out.println("go to login boot");
		return "login";
	}
	

}

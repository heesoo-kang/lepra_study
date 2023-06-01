package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
 

@Controller
public class LoginController {
	


  @RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
  public String host(HttpServletRequest request) {
	 jakarta.servlet.http.HttpSession session = request.getSession();
	 UUID login_token = UUID.randomUUID();
 	 session.setAttribute("login_token",login_token);
 	 
 	 System.out.println("login /, home: "+session.getAttribute("login_token"));
	 return "login";
  }
  
  @RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {

		session.invalidate();
		return "redirect:/user/login";
	}
	
}
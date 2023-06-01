package com.instagram.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.demo.dao.UserDAO;
import com.instagram.demo.dao.impl.UserDAOImpl;
import com.instagram.demo.dto.LoginDTO;
import com.instagram.demo.vo.LoginVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO UserDAO;
	
//	@GetMapping("/")
//	public String basics(HttpServletRequest request) {
//		System.out.println("go to main1");
//		jakarta.servlet.http.HttpSession session = request.getSession();
//		UUID login_token = UUID.randomUUID();
//	 	session.setAttribute("login_token",login_token);
//		return "main";
//	}
	

	@RequestMapping(value = {"/","/instagram"}, method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		System.out.println("go to main2");
		jakarta.servlet.http.HttpSession session = request.getSession();
		UUID login_token = UUID.randomUUID();
	 	session.setAttribute("login_token",login_token);
		return "main";
	}
	
}

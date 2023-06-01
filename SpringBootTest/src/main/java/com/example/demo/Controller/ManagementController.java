package com.example.demo.Controller;

import java.util.Enumeration;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sql.UserSql;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/manager")
class ManagementController {

	@Autowired
	UserSql UserRepository;
	
	@RequestMapping(value= {"/management"})
	public String management(Model model, HttpServletRequest response) {
		
		jakarta.servlet.http.HttpSession session = response.getSession();

	    session.getAttribute("userlole");
	    System.out.println("session.getAttribute(\"userlole\").equals(0): "+session.getAttribute("userlole").equals("0"));
	    System.out.println("login tokens : "+ session.getAttribute("login-token"));
	    System.out.println("test tokens : "+ session.getAttribute("teststr"));

	    UUID manage_token = UUID.randomUUID();
	    session.setAttribute("manage_token",manage_token) ;
	    
		if(session.getAttribute("login_token")==null){
			return "redirect:/home";
		}else if(session.getAttribute("userlole").equals("0") ) {
			UserRepository.getAllUserList(model);
			System.out.println("getAllUserList");
			return "Management_screen";		
			 
		}else {
			return "redirect:/schedule/list";	
		}	
	}
	
	@RequestMapping(value= {"/add_user"})
	public String add_user(HttpServletRequest response) {
		
		jakarta.servlet.http.HttpSession session = response.getSession();
	  
	    String token_chk = response.getParameter("manage_token");
	    System.out.println("token_chk - manager con"
	    		+ "; "+ token_chk);

		if(	String.valueOf(session.getAttribute("manage_token")).equals(token_chk)) {
			UUID add_token = UUID.randomUUID();
		    session.setAttribute("add_token",add_token) ;
			
			System.out.println("goto add user ");
			return "add_user";	
			
		}else {
			
			return "redirect:/home";	
		}	
	}
	
	@RequestMapping(value= {"/edit_user"})
	public String edit_user(HttpServletRequest response) {
		
		jakarta.servlet.http.HttpSession session = response.getSession();
	    String token_chk = response.getParameter("manage_token");
	    
	    UUID edit_token = UUID.randomUUID();
	    session.setAttribute("edit_token",edit_token) ;
	    
	    if(	String.valueOf(session.getAttribute("manage_token")).equals(token_chk)) {
			System.out.println("goto edit user ");
			return "edit_user";
			
		}else {
			
			return "redirect:/home";	
		}
	}
}

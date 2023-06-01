package com.example.demo.sessionchk;

import jakarta.servlet.http.HttpServletRequest;

public class Sessionchk {

	
	public String sessionchk(HttpServletRequest request) {
		
		jakarta.servlet.http.HttpSession session = request.getSession();
		
		session.getAttribute("UUID");
		System.out.println("session.getAttribute(\"UUID\": "+session.getAttribute("UUID"));
		return "Management_screen";		
	}
}

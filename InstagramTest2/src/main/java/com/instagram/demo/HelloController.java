package com.instagram.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/t")
	public String hello() {
		return "idex";
	}
}

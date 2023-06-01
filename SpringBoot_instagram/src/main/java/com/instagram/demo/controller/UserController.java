package com.instagram.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.demo.dao.FeedDAO;
import com.instagram.demo.dao.UserDAO;
import com.instagram.demo.dto.JoinDTO;
import com.instagram.demo.dto.LoginDTO;
import com.instagram.demo.vo.FeedVO;
import com.instagram.demo.vo.LoginVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	@PostMapping(value = "/login")
	public @ResponseBody String loginchk(LoginDTO loginDTO,Model model, HttpServletRequest request) {
		jakarta.servlet.http.HttpSession session = request.getSession();
		System.out.println("login chk");
		System.out.println("user id: "+loginDTO.getAccount());
		System.out.println("before sha pass: "+ loginDTO.getUserpw());
		String encrypassword = Sha256.encrypt(loginDTO.getUserpw());
		loginDTO.setUserpw(encrypassword);
		LoginVO loginVO = userDAO.login(loginDTO);
		System.out.println("login vo : "+ loginVO);
		System.out.println(loginVO.getAccount());
		System.out.println(loginVO.getName());
		session.setAttribute("loginvo", loginVO);
		
		model.addAttribute("loginvo",loginVO);
	
		if (loginVO.getAccount()==null){
			return "login fail";
		}else{
			return "ok";
		}
	}
	
	@GetMapping("/join_user")
	public String join() {
		return "join_user";
	}
	
	@PostMapping(value = "/join_user")
	public @ResponseBody String join_user(JoinDTO joinDTO, Model model) {
		
		System.out.println(joinDTO.toString());
		String encrypassword = Sha256.encrypt(joinDTO.getUserpw());
		joinDTO.setUserpw(encrypassword);
		userDAO.joinUser(joinDTO);
		
		return "join ok";
	}

}

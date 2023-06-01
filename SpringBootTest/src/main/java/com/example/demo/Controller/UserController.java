package com.example.demo.Controller;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.sql.UserSql;
import com.example.demo.util.XssUtil;
import com.example.demo.vo.LoginVO;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	UserSql UserRepository;
	XssUtil xssutil;

	 @RequestMapping(value = {"/login", "/home"}, method=RequestMethod.GET)
	 public String host(HttpServletRequest request) {
		 jakarta.servlet.http.HttpSession session = request.getSession();
		 UUID login_token = UUID.randomUUID();
	 	 session.setAttribute("login_token",login_token);
		 return "login";
	 }

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Object login(LoginDTO loginDTO ,String token,HttpServletRequest request, Model model ) {
		jakarta.servlet.http.HttpSession session = request.getSession();
		System.out.println(loginDTO);
		
		System.out.println(loginDTO.getUseraccount());
		System.out.println(loginDTO.getUserpw());
		System.out.println(token.getClass().getName());
		System.out.println("token: "+ token);
		System.out.println("xssutil account:"+XssUtil.cleanXSS(loginDTO.getUseraccount()));
		System.out.println("xssutil pw:"+XssUtil.cleanXSS(loginDTO.getUserpw()));
		
		
		Map<String, Object> loginvo = UserRepository.login(loginDTO.getUseraccount(),loginDTO.getUserpw());
		System.out.println("------------loginvo: "+loginvo);		
		
		if(String.valueOf(session.getAttribute("login_token")).equals(token)) {
			session.setAttribute("userid", loginvo.get("account"));
	 		session.setAttribute("username", loginvo.get("name"));
	 		session.setAttribute("userlole", loginvo.get("role"));
	 		
	 		return loginvo;	
	 		
		}else{
			return "loginFail";
		}
	}

	@RequestMapping(value="/idchk", method=RequestMethod.POST)
	public @ResponseBody String user_idck(UserDTO userDTO) {

	    System.out.println("user_idck - userDTO: "+ userDTO);	
		return UserRepository.user_idck(userDTO.getUseraccount());
			
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String add_user(UserDTO userDTO, HttpServletRequest response) {
		jakarta.servlet.http.HttpSession session = response.getSession();
	    String token_chk = response.getParameter("add_token");
	    System.out.println("userDTO: "+ userDTO);
		
		if(String.valueOf(session.getAttribute("add_token")).equals(token_chk)) {
			int result = UserRepository.insertuser(userDTO.getUseraccount(), userDTO.getUsername(), userDTO.getUserpw(), userDTO.getUserrole());
			System.out.println("insert result : "+result);
			System.out.println("insert.toString(result) : "+ Integer.toString(result));
			return Integer.toString(result);
			
		}else {
			return "異常 アクセス";
		}		
	}
	
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public @ResponseBody String edit_user(UserDTO userDTO, HttpServletRequest response) {
		jakarta.servlet.http.HttpSession session = response.getSession();
		String token_chk = response.getParameter("edit_token");
		System.out.println("userDTO: "+userDTO);
		
		if(String.valueOf(session.getAttribute("edit_token")).equals(token_chk)) {
			
			System.out.println(" userDTO.getUserpw() : "+userDTO.getUserpw().equals(""));
			
			int result = UserRepository.edituser(userDTO.getUseraccount(), userDTO.getUsername(), userDTO.getUserpw(),userDTO.getUserrole(), userDTO.getUservalid());
			System.out.println("edit result : "+result);
			System.out.println("edit.toString(result : "+ Integer.toString(result));
			return Integer.toString(result);
			
		}else {
			if(token_chk==null) {
				return "異常 アクセス";
			}else {
				return "Token 不一致";
			}
		}
	}

	@RequestMapping(value = "/getSearchuser", method=RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> searchuser(HttpServletRequest request){
		/*
		 * jakarta.servlet.http.HttpSession session = request.getSession();
		 * System.out.println("session.getAttribute(\"UUID\"): "+session.getAttribute(
		 * "UUID"));
		 */
		
		System.out.println("=========================in getSearchuser=========================");
		String id = request.getParameter("userid");
		String account = request.getParameter("useraccount");
		String name = request.getParameter("username");
		String valid = request.getParameter("uservalid");
		System.out.println("id account name valid "+id+" "+account+" "+name+ " "+ valid);
		
		return UserRepository.searchuser(id, name, account,valid );
		
	}
	
	@RequestMapping(value = "/search_init", method=RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> search_init(HttpServletRequest request, String token){
		
		System.out.println("=========================in search_init=========================");
		
		jakarta.servlet.http.HttpSession session = request.getSession();
		return UserRepository.search_init();
		
		/*
		 * if(String.valueOf(session.getAttribute("manage_token")).equals(token)) {
		 * 
		 * 
		 * return "異常アクセス";
		 * 
		 * }else{ return UserRepository.search_init(); }
		 */
	}

}

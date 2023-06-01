package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.vo.LoginVO;

public class UserDAO {
//	
	
	  @Autowired JdbcTemplate jdbcTemplate;
	  
	  public String[] login(LoginDTO loginDTO) { String id = loginDTO.getUseraccount();
	  String pw = loginDTO.getUserpw(); 
	  String usernamecheck; 
	  String userrolecheck; 
	  usernamecheck = jdbcTemplate.queryForObject("select name from USER where id = ? and password = ?",
	  String.class,id,pw); 
	  userrolecheck = jdbcTemplate.queryForObject("select power from USER where id = ? and password = ?",
	  String.class,id,pw); 
	  
	  return new String[] {usernamecheck, userrolecheck};
	  
	  }
	 
}

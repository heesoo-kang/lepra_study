package com.example.demo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.dao.UserDAO;
import com.example.demo.vo.LoginVO;


@Repository
public class UserDAOImpl {
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//    @jakarta.inject.Inject
//	protected SqlSession sqlSession;
//
//	private static final String namespace = "com.example.demo.static.mapper.test.";
//	public String checkLoginuser(String id, String pw){
//		String usercheck;
//		usercheck = jdbcTemplate.queryForObject("select name from MEMBER where id = ? and password = ?", String.class,id,pw);
//		System.out.println("usercheck==========================================================");
//		System.out.println(usercheck);
//		System.out.println("usercheck==========================================================");
//
//		return usercheck;
//		
//	}
//	@Override
//	public LoginVO login(LoginDTO loginDTO) {
//		return sqlSession.selectOne(namespace+"login", loginDTO);
//	}
	/*
	 * @Override public LoginVO login(LoginDTO loginDTO) { String id =
	 * loginDTO.getUserid(); String pw = loginDTO.getUserpw(); LoginVO
	 * usernamecheck; usernamecheck = jdbcTemplate.
	 * queryForObject("select name from MEMBER where id = ? and password = ?",
	 * String.class,id,pw); System.out.println(
	 * "usernamecheck==========================================================");
	 * System.out.println(usernamecheck); System.out.println(
	 * "usernamecheck==========================================================");
	 * 
	 * return usernamecheck; }
	 */

}

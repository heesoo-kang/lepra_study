package com.instagram.demo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.UserDAO;
import com.instagram.demo.dto.JoinDTO;
import com.instagram.demo.dto.LoginDTO;
import com.instagram.demo.vo.LoginVO;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.UserMapper.";
	
	@Override
	public void joinUser(JoinDTO joinDTO) {
		sqlSession.insert(namespace+"join",joinDTO);
	}

	@Override
	public LoginVO login(LoginDTO loginDTO) {
		System.out.println("userdao impl");
		return sqlSession.selectOne(namespace+"login",loginDTO);
	}

}

package com.instagram.demo.dao;

import com.instagram.demo.dto.JoinDTO;
import com.instagram.demo.dto.LoginDTO;
import com.instagram.demo.vo.LoginVO;

public interface UserDAO {
	
	public void joinUser(JoinDTO joinDTO);
	public LoginVO login(LoginDTO loginDTO);

}

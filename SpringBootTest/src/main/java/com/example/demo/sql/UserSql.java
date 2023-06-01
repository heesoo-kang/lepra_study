package com.example.demo.sql;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.LoginVO;
import com.example.demo.vo.UserVO;



@Repository
public class UserSql {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getAllUserList(Model model){
		List<Map<String, Object>> userlist = jdbcTemplate.queryForList("select * from USER;");
		model.addAttribute("userlist",userlist);	
		System.out.println("userlist :"+userlist);
	
	}
	
	public Map<String, Object> login(String id, String pw) {
		Map<String, Object> loginchk;
		
		try {
			
			loginchk = jdbcTemplate.queryForMap("select * from USER where account = ? and password = (SELECT SHA2(?,256))", id,pw);
	
		}catch (Exception e) {
			return null;
		}
		return loginchk;
		
	}

	
	public String user_idck(String useraccount) {	
		String idchk;
		try {
			idchk = jdbcTemplate.queryForObject("select 1 from USER where account = ? ", String.class,useraccount);
	
		} catch (Exception e) {
			idchk= "0";
		}
		
		return idchk;
	}
	
	public int insertuser(String account,String pw, String name,  String role ){	
		int inseruser;
		
		try {
			if (role == null) {
				role="1";
			}
			
			inseruser = jdbcTemplate.update("INSERT INTO USER (account,password, name, role,valid) VALUES (?,(SELECT SHA2(?,256)),?,?,?)",account,name,pw,role,"true");		
			System.out.println("insert user: "+inseruser);
		} catch (Exception e) {
			inseruser= 0;
		}

		return inseruser;
	}
	
	public int edituser(String account,String name, String pw, String role,String valid ){	
		int edituser;
		System.out.println("account-------------------"+account);
		System.out.println("pw-------------------"+pw);
		System.out.println("name-------------------"+name);
		System.out.println("role-------------------"+role);
		System.out.println("valid-------------------"+valid);
		
		try {
			edituser = jdbcTemplate.update("Update USER  SET name=?,password=(SELECT SHA2(?,256)),role=?, valid=? WHERE account =?",name,pw,role,valid,account);	
			System.out.println("edituser: "+edituser);
		} catch (Exception e) {
			edituser= 0;
		}
		
		return edituser;
	}
	
	public List<Map<String, Object>> searchuser(String id,String name, String account,String valid ){	
		System.out.println("go to searchuser");
		List<Map<String, Object>> searchuser;
		
		try {
			if(valid.equals("false")){
				System.out.println("valid false");
				searchuser = jdbcTemplate.queryForList("select * from USER where id=? or account=? or name=? ",id,account,name);
						
			}else {
				System.out.println("valid true?:" + valid.equals("false"));
				searchuser = jdbcTemplate.queryForList("select * from (select * from USER where id=? or account=? or name=? )as subuser where valid =?;",id,account,name,valid);
			}
			
			System.out.println("searchuser:sql "+ searchuser);
			return  searchuser;
			
		} catch (Exception e) {
			searchuser = null;
			
			System.out.println("searchuser:sql "+ searchuser);
			return  searchuser;
		}
	}
	public List<Map<String, Object>> search_init(){	
		System.out.println("go to search_init");
		List<Map<String, Object>> searchuser;
		
		try {
			searchuser = jdbcTemplate.queryForList("select * from USER ");
			System.out.println("search_init:sql "+ searchuser);
			return  searchuser;	
		} catch (Exception e) {
			searchuser = null;
			System.out.println("search_init:sql "+ searchuser);
			return  searchuser;
		}
	}
}

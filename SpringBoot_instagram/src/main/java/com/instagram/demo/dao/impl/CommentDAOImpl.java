package com.instagram.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.CommentDAO;
import com.instagram.demo.dto.CommentDTO;
import com.instagram.demo.vo.CommentVO;


@Repository
public class CommentDAOImpl  implements CommentDAO {
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.CommentMapper.";
	

	@Override
	public void commentinsert(CommentDTO commentDTO) {
		System.out.println("comment insert");
		sqlSession.insert(namespace+"commentinsert", commentDTO);
		
	}

	@Override
	public List<CommentVO> CommentImport(String feednumber) {
		System.out.println("comment list start");
		System.out.println("feed number: "+ feednumber);
		return sqlSession.selectList(namespace+"commentlist",feednumber);
	}

}

package com.instagram.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.LikeDAO;
import com.instagram.demo.dto.LikeDTO;
import com.instagram.demo.vo.LikeVO;


@Repository
public class LikeDAOImpl implements LikeDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.LikeMapper.";
	
	@Override
	public void Likein(LikeDTO likeDTO) {
		System.out.println("like insert");
		sqlSession.insert(namespace+"Likein",likeDTO);
	}


	@Override
	public void Likeout(LikeDTO likeDTO) {
		System.out.println("like out");
		sqlSession.insert(namespace+"Likeout",likeDTO);
	}

	@Override
	public List<LikeVO> likelist(String account) {
	
		System.out.println("like list search");
		System.out.println("feed_number21: ");
		
		return sqlSession.selectList(namespace+"Likelist",account);
	}
	

}

package com.instagram.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.FeedDAO;
import com.instagram.demo.dto.FeedDTO;
import com.instagram.demo.vo.FeedVO;

@Repository
public class FeedDAOImpl extends AbstractDAO implements FeedDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.FeedMapper.";
	
	@Override
	public void FeedUpload(FeedDTO feedDTO) {
		System.out.println("FeedUpload start");
		sqlSession.insert(namespace+"Feedupload",feedDTO);
		System.out.println("FeedUpload end");
	}

	@Override
	public List<FeedVO> FeedImport(String account) {
		System.out.println("Feed_Import start");
	
		return sqlSession.selectList(namespace+"FeedImport",account);
	}

}

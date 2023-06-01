package com.instagram.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.MypageDAO;
import com.instagram.demo.vo.FeedVO;
import com.instagram.demo.vo.FollowFeedSetVO;


@Repository
public class MypageDAOImpl implements MypageDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.MypageMapper.";
	
	@Override
	public List<FeedVO> MyFeedlist(String account) {
		System.out.println("My Feed list start");
		
		return sqlSession.selectList(namespace+"MyFeedlist",account);
	}

	@Override
	public FollowFeedSetVO MyFollow_Feed_set(String account) {
		System.out.println("MyFollow_Feed_set start");
		return sqlSession.selectOne(namespace+"MyFollow_Feed_set", account);
	}

	@Override
	public List<FeedVO> BookmarkFeed(String account) {
		System.out.println("BookmarkFeed start");
		return sqlSession.selectList(namespace+"Mybookmarklist", account);
	}

}

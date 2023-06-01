package com.instagram.demo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.demo.dao.BookmarkDAO;
import com.instagram.demo.dto.BookmarkDTO;
import com.instagram.demo.vo.BookmarkVO;

@Repository
public class BookmarkDAOImpl implements BookmarkDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace= "com.instagram.demo.mapper.BookmarkMapper.";
	
	@Override
	public void Bookmarkin(BookmarkDTO bookmarkDTO) {
		System.out.println("bookmark in");
		System.out.println(bookmarkDTO.toString());
		sqlSession.insert(namespace+"Bookmarkin",bookmarkDTO);
	}
	@Override
	public void Bookmarkout(BookmarkDTO bookmarkDTO) {
		System.out.println("bookmark out");
		sqlSession.insert(namespace+"Bookmarkout",bookmarkDTO);
	}
	@Override
	public List<BookmarkVO> bookmarklist(String account) {

		System.out.println("Bookmark list search");

		return sqlSession.selectList(namespace+"Bookmarklist",account);
	}
}

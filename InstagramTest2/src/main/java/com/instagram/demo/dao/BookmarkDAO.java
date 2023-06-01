package com.instagram.demo.dao;

import java.util.List;

import com.instagram.demo.dto.BookmarkDTO;
import com.instagram.demo.vo.BookmarkVO;

public interface BookmarkDAO {
	
	public void Bookmarkin(BookmarkDTO bookmarkDTO);
	public void Bookmarkout(BookmarkDTO bookmarkDTO);
	List<BookmarkVO> bookmarklist(String account);

}

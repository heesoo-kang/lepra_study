package com.instagram.demo.dao;

import java.util.List;

import com.instagram.demo.dto.CommentDTO;
import com.instagram.demo.vo.CommentVO;

public interface CommentDAO {
	
	public void commentinsert(CommentDTO commentDTO);
	List<CommentVO> CommentImport(String feednumber);

}

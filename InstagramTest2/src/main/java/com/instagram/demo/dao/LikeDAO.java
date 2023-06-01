package com.instagram.demo.dao;

import java.util.List;

import com.instagram.demo.dto.LikeDTO;
import com.instagram.demo.vo.LikeVO;

public interface LikeDAO {

	public void Likein(LikeDTO likeDTO);
	public void Likeout(LikeDTO likeDTO);
	List<LikeVO>  likelist(String account);

}

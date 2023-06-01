package com.instagram.demo.dao;

import java.util.List;

import com.instagram.demo.dto.FeedDTO;
import com.instagram.demo.vo.FeedVO;

public interface FeedDAO {
	public void FeedUpload(FeedDTO feedDTO);
	List<FeedVO>  FeedImport(String account);
	
}

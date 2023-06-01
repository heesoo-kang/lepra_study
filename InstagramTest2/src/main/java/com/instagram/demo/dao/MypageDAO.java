package com.instagram.demo.dao;

import java.util.List;

import com.instagram.demo.vo.FeedVO;
import com.instagram.demo.vo.FollowFeedSetVO;

public interface MypageDAO {
	
	List<FeedVO>  MyFeedlist(String account);
	public FollowFeedSetVO MyFollow_Feed_set(String account);
	List<FeedVO>  BookmarkFeed(String account);

}

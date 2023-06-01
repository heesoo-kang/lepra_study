package com.instagram.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.demo.dao.FeedDAO;
import com.instagram.demo.dao.MypageDAO;
import com.instagram.demo.vo.FeedVO;
import com.instagram.demo.vo.FollowFeedSetVO;

@Controller
public class MypageController {
	@Autowired
	private MypageDAO mypagedao;
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@PostMapping(value = "/myfeed")
	@ResponseBody
	public List<FeedVO> myfeedlist(String account){
		System.out.println("my feedlist chk");
		List<FeedVO> myfeedvo = mypagedao.MyFeedlist(account);
		
		System.out.println(myfeedvo.toString());
		
		return myfeedvo;
	}
	
	@PostMapping(value = "/MyFollow_Feed_set")
	@ResponseBody
	public FollowFeedSetVO MyFollow_Feed_set(String account){
		System.out.println("my feedlist chk");
		FollowFeedSetVO FollowFeedSetVO = mypagedao.MyFollow_Feed_set(account);
		
		System.out.println(FollowFeedSetVO.toString());
		
		return FollowFeedSetVO;
	}
	
	@PostMapping(value = "/MyBookmarkFeed")
	@ResponseBody
	public List<FeedVO> BookmarkFeed(String account){
		System.out.println("my BookmarkFeed chk");
		List<FeedVO> myfeedvo = mypagedao.BookmarkFeed(account);
		
		System.out.println(myfeedvo.toString());
		
		return myfeedvo;
	}

}

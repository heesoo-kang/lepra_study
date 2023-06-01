package com.instagram.demo.vo;

public class LikeVO {
	private String feed_number;
	private String likecount; //feed upload user
	private String account; //feed upload user]
	public String getFeed_number() {
		return feed_number;
	}
	public void setFeed_number(String feed_number) {
		this.feed_number = feed_number;
	}
	public String getLikecount() {
		return likecount;
	}
	public void setLikecount(String likecount) {
		this.likecount = likecount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "LikeVO [feed_number=" + feed_number + ", likecount=" + likecount + ", account=" + account + "]";
	}
	
	
	
	

}

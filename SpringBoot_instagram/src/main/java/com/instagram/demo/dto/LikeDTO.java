package com.instagram.demo.dto;

public class LikeDTO {
	
	private String feed_number;
	private String account; //fullname
	
	public String getFeed_number() {
		return feed_number;
	}
	public void setFeed_number(String feed_number) {
		this.feed_number = feed_number;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	@Override
	public String toString() {
		return "LikeDTO [feed_number=" + feed_number + ", account=" + account + "]";
	}
	
	

}

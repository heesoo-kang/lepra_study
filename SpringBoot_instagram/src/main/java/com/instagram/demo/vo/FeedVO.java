package com.instagram.demo.vo;

public class FeedVO {
	
	private String feed_number; //feed upload user
	private String account; //feed upload user]
	private String comment; //feed upload user
	private String picture_address; //feed upload user
	private String profile_image;
	private String likecount;
	private String likeuser;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPicture_address() {
		return picture_address;
	}
	public void setPicture_address(String picture_address) {
		this.picture_address = picture_address;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getLikecount() {
		return likecount;
	}
	public void setLikecount(String likecount) {
		this.likecount = likecount;
	}
	public String getLikeuser() {
		return likeuser;
	}
	public void setLikeuser(String likeuser) {
		this.likeuser = likeuser;
	}
	
	
	@Override
	public String toString() {
		return "FeedVO [feed_number=" + feed_number + ", account=" + account + ", comment=" + comment
				+ ", picture_address=" + picture_address + ", profile_image=" + profile_image + ", likecount="
				+ likecount + ", likeuser=" + likeuser + "]";
	}
	
	
}

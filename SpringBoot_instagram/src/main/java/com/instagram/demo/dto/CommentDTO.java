package com.instagram.demo.dto;

public class CommentDTO {
	private String feed_number;
	private String comment_user;
	private String comment;
	
	public String getFeed_number() {
		return feed_number;
	}
	public void setFeed_number(String feed_number) {
		this.feed_number = feed_number;
	}
	public String getComment_user() {
		return comment_user;
	}
	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [feed_number=" + feed_number + ", comment_user=" + comment_user + ", comment=" + comment
				+ "]";
	}
	
	

}

package com.instagram.demo.vo;

public class BookmarkVO {
	
	private String feed_number;

	private String bookmark_user;

	public String getFeed_number() {
		return feed_number;
	}

	public void setFeed_number(String feed_number) {
		this.feed_number = feed_number;
	}

	public String getBookmark_user() {
		return bookmark_user;
	}

	public void setBookmark_user(String bookmark_user) {
		this.bookmark_user = bookmark_user;
	}

	@Override
	public String toString() {
		return "BookmarkVO [feed_number=" + feed_number + ", bookmark_user=" + bookmark_user + "]";
	}
	
	

}

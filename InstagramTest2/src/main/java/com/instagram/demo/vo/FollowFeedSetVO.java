package com.instagram.demo.vo;

public class FollowFeedSetVO {
	private String myfeedcount;
	private String followernum;
	private String followeenum;
	public String getMyfeedcount() {
		return myfeedcount;
	}
	public void setMyfeedcount(String myfeedcount) {
		this.myfeedcount = myfeedcount;
	}
	public String getFollowernum() {
		return followernum;
	}
	public void setFollowernum(String followernum) {
		this.followernum = followernum;
	}
	public String getFolloweenum() {
		return followeenum;
	}
	public void setFolloweenum(String followeenum) {
		this.followeenum = followeenum;
	}
	@Override
	public String toString() {
		return "FollowFeedSetVO [myfeedcount=" + myfeedcount + ", followernum=" + followernum + ", followeenum="
				+ followeenum + "]";
	}
	
	
	
}

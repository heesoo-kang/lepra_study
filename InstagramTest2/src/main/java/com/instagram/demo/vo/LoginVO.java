package com.instagram.demo.vo;

public class LoginVO {

	private String account;
	private String name;
	private String profile_image;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	
	@Override
	public String toString() {
		return "LoginVO [account=" + account + ", name=" + name + ", profile_image=" + profile_image + "]";
	}
	
}

package com.instagram.demo.dto;

public class JoinDTO {
	
	private String email;
	private String account; //fullname
	private String userpw;
	private String name;   //username
	private String phone;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "JoinDTO [email=" + email + ", account=" + account + ", userpw=" + userpw + ", name=" + name + ", phone="
				+ phone + ", getEmail()=" + getEmail() + ", getAccount()=" + getAccount() + ", getUserpw()="
				+ getUserpw() + ", getName()=" + getName() + ", getPhone()=" + getPhone() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

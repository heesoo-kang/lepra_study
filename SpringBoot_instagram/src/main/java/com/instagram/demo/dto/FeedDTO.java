package com.instagram.demo.dto;

/*import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;*/


public class FeedDTO {
	

	private String account; //feed upload user]
	private String comment;
	private String picture_address; //feed upload user
	
	/*
	 * private MultipartFile attachFile; 
	 * private List<MultipartFile> imageFiles;
	 */
	
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
	@Override
	public String toString() {
		return "FeedDTO [account=" + account + ", comment=" + comment + ", picture_address=" + picture_address + "]";
	}
	
	
	

}

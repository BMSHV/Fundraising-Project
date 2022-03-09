package com.abc.fundraising.model;

import java.time.LocalDate;

public class Post 
{
	private int postId;
	private int userId;
	private int donorId;
	private LocalDate postDate;
	private String categoryName;
	private String userDescription;
	private double fundNeeded;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public double getFundNeeded() {
		return fundNeeded;
	}
	public void setFundNeeded(double fundNeeded) {
		this.fundNeeded = fundNeeded;
	}

	
}

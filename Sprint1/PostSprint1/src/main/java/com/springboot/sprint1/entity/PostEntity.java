package com.springboot.sprint1.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_tbl")
public class PostEntity {
	
	@Id
	@Column(name = "postId")
	private int postId;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "donorId")
	private int donorId;
	
	@Column(name = "postDate")
	private LocalDate postDate;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	@Column(name = "userDescription")
	private String userDescription;
	
	@Column(name = "fundNeeded")
	private float fundNeeded;
	
	@Column(name = "fundCollected")
	private float fundCollected;

	public float getFundCollected() {
		return fundCollected;
	}

	public void setFundCollected(float fundCollected) {
		this.fundCollected = fundCollected;
	}

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

	public float getFundNeeded() {
		return fundNeeded;
	}

	public void setFundNeeded(float fundNeeded) {
		this.fundNeeded = fundNeeded;
	}

}

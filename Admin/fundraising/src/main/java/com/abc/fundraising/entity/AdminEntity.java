package com.abc.fundraising.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="admin_tbl")
public class AdminEntity 
{
	@Id
	@Column(name="admin_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@ApiModelProperty(notes = "ID of the admin",name="AdminId",required=false,value="Auto generated")
	private int adminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="user_id")
	//@ApiModelProperty(notes = "ID of the user",name="UserId",required=false,value="Auto generated")
	private int userId;
	
	@Column(name="post_id")
	//@ApiModelProperty(notes = "ID of the admin",name="AdminId",required=false,value="Auto generated")
	private int  postId;
	
	@Column(name="category_id")
	//@ApiModelProperty(notes = "ID of the admin",name="CategoryId",required=false,value="Auto generated")
	private int categoryId;
	
	@Column(name="donor_id")
	//@ApiModelProperty(notes = "ID of the admin",name="DonorId",required=false,value="Auto generated")
	private int donorId;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

}

package com.example.fundRaisingApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donor_table")
public class DonorEntity {

	@Id
	@Column(name = "donor_id")
	private int donorId;

	@Column(name = "donor_name")
	private String donorName;

	@Column(name = "donor_email")
	private String donorEmail;

	@Column(name = "donor_number")
	private Long donorNumber;

	@Column(name = "donor_address")
	private String donorAddress;

	@Column(name = "donor_amount")
	private double donorAmount;

	@Column(name = "user_id")
	private int userId;

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

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public Long getDonorNumber() {
		return donorNumber;
	}

	public void setDonorNumber(Long donorNumber) {
		this.donorNumber = donorNumber;
	}

	public String getDonorAddress() {
		return donorAddress;
	}

	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	public double getDonorAmount() {
		return donorAmount;
	}

	public void setDonorAmount(double donorAmount) {
		this.donorAmount = donorAmount;
	}

}

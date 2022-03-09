package com.example.fundRaisingApp.model;

public class DonorModel {

	private int donorId;
	private String donorName;
	private String donorEmail;
	private String donorAddress;
	private long donorNumber;
	private double donorAmount;
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

	public String getDonorAddress() {
		return donorAddress;
	}

	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	public long getDonorNumber() {
		return donorNumber;
	}

	public void setDonorNumber(long donorNumber) {
		this.donorNumber = donorNumber;
	}

	public double getDonorAmount() {
		return donorAmount;
	}

	public void setDonorAmount(double donorAmount) {
		this.donorAmount = donorAmount;
	}

}

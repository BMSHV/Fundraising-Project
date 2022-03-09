package com.springboot.sprint1.model;

public class Donor {

	private int donorId;

	private int userId;

	private int causeId;
	private String donorName;
	private String donorAddress;
	private String donorEmail;
	private long donorNumber;
	private double donorAmount;
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCauseId() {
		return causeId;
	}
	public void setCauseId(int causeId) {
		this.causeId = causeId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}
	public String getDonorEmail() {
		return donorEmail;
	}
	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
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

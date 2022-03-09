package com.abc.fundraising.model;

public class Donor {
	
	private int donorId;
	private String donorName;
	private String donorAddress;
	private String donorEmail;
	private String donorMobile;
	private double donatedAmount;
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
	public String getDonorMobile() {
		return donorMobile;
	}
	public void setDonorMobile(String donorMobile) {
		this.donorMobile = donorMobile;
	}
	public double getDonatedAmount() {
		return donatedAmount;
	}
	public void setDonatedAmount(double donatedAmount) {
		this.donatedAmount = donatedAmount;
	}

}

package com.cloud.fundamentals.vo;

public class PlanVO {
	private String planName;
	private double price;
	private int data;
	
	public PlanVO() {
		
	}
	public PlanVO(String planName, double price, int data) {
		super();
		this.planName = planName;
		this.price = price;
		this.data = data;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}

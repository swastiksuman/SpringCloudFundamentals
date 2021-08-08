package com.cloud.fundamentals.graphqlserver.vo;

public class PlanVO {
	private String planName;
	private String price;
	private String data;

	public PlanVO() {

	}

	public PlanVO(String planName, String price, String data) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PlanVO [planName=" + planName + ", price=" + price + ", data=" + data + "]";
	}

}
package com.cloud.fundamentals.graphqlserver.vo;

public class ProductVO {
	private String productId;
	private String productName;
	private String imageUrl;

	public ProductVO() {

	}

	public ProductVO(String productId, String productName, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}

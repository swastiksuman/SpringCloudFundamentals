package com.cloud.fundamentals.serviceproduct.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloud.fundamentals.serviceproduct.vo.ProductVO;

@Component
public class ProductService {
	public List<ProductVO> fetchProducts(){
		ProductVO productVO1 = new ProductVO();
		productVO1.setProductId(123);
		productVO1.setProductName("iPhone 12");
		productVO1.setImageUrl("https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-12.jpg");
		ProductVO productVO2 = new ProductVO();
		productVO2.setProductId(124);
		productVO2.setProductName("Samsung S10 Lite");
		productVO2.setImageUrl("https://fdn2.gsmarena.com/vv/bigpic/sasmung-galaxy-s10-lite-.jpg");
		ProductVO productVO3 = new ProductVO();
		productVO3.setProductId(125);
		productVO3.setProductName("Mi 10 5G");
		productVO3.setImageUrl("https://fdn2.gsmarena.com/vv/bigpic/xiaomi-mi-10-5g.jpg");
		List<ProductVO> listOfProducts = new ArrayList<ProductVO>();
		listOfProducts.add(productVO1);
		listOfProducts.add(productVO2);
		listOfProducts.add(productVO3);
		return listOfProducts;
	}
}

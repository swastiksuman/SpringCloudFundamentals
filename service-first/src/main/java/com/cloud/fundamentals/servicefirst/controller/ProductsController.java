package com.cloud.fundamentals.servicefirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.fundamentals.servicefirst.dto.ProductSearchDto;
import com.cloud.fundamentals.servicefirst.service.ProductService;

@RestController
public class ProductsController {
	
	@Autowired
	ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/searchProduct")
	public ProductSearchDto searchProducts() {
		ProductSearchDto productSearchDto = new ProductSearchDto();
		productSearchDto.setSearchResult(productService.fetchProducts());
		return productSearchDto;
	}
}

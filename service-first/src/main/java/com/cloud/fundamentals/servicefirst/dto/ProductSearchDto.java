package com.cloud.fundamentals.servicefirst.dto;

import java.util.ArrayList;
import java.util.List;

import com.cloud.fundamentals.servicefirst.vo.ProductVO;

public class ProductSearchDto {
	private List<ProductVO> searchResult = new ArrayList<ProductVO>();

	public List<ProductVO> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<ProductVO> searchResult) {
		this.searchResult = searchResult;
	}

}

package com.cloud.fundamentals.serviceproduct.dto;

import java.util.ArrayList;
import java.util.List;

import com.cloud.fundamentals.serviceproduct.vo.ProductVO;

public class ProductSearchDto {
	private List<ProductVO> searchResult = new ArrayList<ProductVO>();

	public List<ProductVO> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<ProductVO> searchResult) {
		this.searchResult = searchResult;
	}

}

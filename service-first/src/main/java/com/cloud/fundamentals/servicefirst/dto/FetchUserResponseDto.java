package com.cloud.fundamentals.servicefirst.dto;

import java.util.ArrayList;
import java.util.List;

import com.cloud.fundamentals.servicefirst.vo.UserVO;

public class FetchUserResponseDto {
	private List<UserVO> searchResult = new ArrayList<UserVO>();

	public List<UserVO> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<UserVO> searchResult) {
		this.searchResult = searchResult;
	}
	
	
}

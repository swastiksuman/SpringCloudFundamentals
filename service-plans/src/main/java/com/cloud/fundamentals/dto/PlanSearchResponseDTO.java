package com.cloud.fundamentals.dto;

import java.util.ArrayList;
import java.util.List;

import com.cloud.fundamentals.vo.PlanVO;

public class PlanSearchResponseDTO {
	private List<PlanVO> listOfPlans = new ArrayList<PlanVO>();

	public List<PlanVO> getListOfPlans() {
		return listOfPlans;
	}

	public void setListOfPlans(List<PlanVO> listOfPlans) {
		this.listOfPlans = listOfPlans;
	}

	public PlanSearchResponseDTO(List<PlanVO> listOfPlans) {
		super();
		this.listOfPlans = listOfPlans;
	}
	
	public PlanSearchResponseDTO() {
		
	}
}

package com.cloud.fundamentals.serviceplans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.fundamentals.dto.PlanSearchResponseDTO;
import com.cloud.fundamentals.serviceplans.service.PlanService;
import com.cloud.fundamentals.vo.PlanVO;

@RestController
public class PlanController {

	@Autowired
	private PlanService planService;

	@GetMapping("/getPlans")
	public PlanSearchResponseDTO getPlans() {
		return new PlanSearchResponseDTO(planService.getPlans());
	}
}

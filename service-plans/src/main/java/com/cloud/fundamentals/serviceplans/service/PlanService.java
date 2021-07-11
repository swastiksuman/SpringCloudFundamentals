package com.cloud.fundamentals.serviceplans.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.fundamentals.vo.PlanVO;

@Service
public class PlanService {
	public List<PlanVO> getPlans() {
		PlanVO plan1 = new PlanVO("Basic", 100.0, 0);
		PlanVO plan2 = new PlanVO("Gold", 200.0, 1024);
		PlanVO plan3 = new PlanVO("Platinum", 300.0, 2048);
		List<PlanVO> listOfPlans = Arrays.asList(plan1, plan2, plan3);
		return listOfPlans;
	}
}

package com.cloud.fundamentals.graphqlserver.query;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cloud.fundamentals.graphqlserver.fetcher.GraphQLDataFetchers;
import com.cloud.fundamentals.graphqlserver.vo.PlanVO;
import com.cloud.fundamentals.graphqlserver.vo.ProductVO;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	public String firstQuery() {
		return "firstQuery";
	}

	public PlanVO getPlan(String planName) {
		List<Map<String, String>> plans = GraphQLDataFetchers.plans.stream()
				.filter((plan) -> ((String) plan.get("planName")).equals(planName)).collect(Collectors.toList());
		return new PlanVO(plans.get(0).get("planName"), plans.get(0).get("price"), plans.get(0).get("data"));
	}
	
	public ProductVO getProduct(String productId) {
		List<Map<String, String>> products = GraphQLDataFetchers.products.stream()
					.filter((product) -> ((String) product.get("productId")).equals(productId)).collect(Collectors.toList());
		return new ProductVO(products.get(0).get("productId"), products.get(0).get("productName"), products.get(0).get("imageUrl"));
	}
	
	public String getPlans(){
		return GraphQLDataFetchers.plans.stream()
			.collect(Collectors.toList()).toString();
	}
}

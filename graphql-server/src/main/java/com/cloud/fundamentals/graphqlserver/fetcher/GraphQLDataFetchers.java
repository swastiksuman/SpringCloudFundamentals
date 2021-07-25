package com.cloud.fundamentals.graphqlserver.fetcher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	private static List<Map<String, String>> plans = Arrays.asList(
			ImmutableMap.of("planName", "basic", "price", "100.0", "data", "0"),
			ImmutableMap.of("planName", "gold", "price", "200.0", "data", "1024"),
			ImmutableMap.of("planName", "platinum", "price", "300.0", "data", "2048"));

	private static List<Map<String, String>> products = Arrays.asList(
			ImmutableMap.of("productId", "101", "productName", "iPhone12", "imageUrl", "https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-12.jpg"),
			ImmutableMap.of("productId", "102", "productName", "Samsung S10 Lite", "imageUrl", "https://fdn2.gsmarena.com/vv/bigpic/sasmung-galaxy-s10-lite-.jpg"),
			ImmutableMap.of("productId", "103", "productName", "Mi 10 5G", "imageUrl", "https://fdn2.gsmarena.com/vv/bigpic/xiaomi-mi-10-5g.jpg"));

	public DataFetcher getPlanByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			String planName = dataFetchingEnvironment.getArgument("id");
			return plans.stream().filter(plan -> plan.get("planName").equals(planName)).findFirst().orElse(null);
		};
	}

	public DataFetcher getProductByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			String productId = dataFetchingEnvironment.getArgument("productId");
			return products.stream().filter(author -> author.get("productId").equals(productId)).findFirst().orElse(null);
		};
	}
}

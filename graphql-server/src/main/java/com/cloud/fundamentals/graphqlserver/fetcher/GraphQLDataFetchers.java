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
			ImmutableMap.of("productId", "author-1", "productName", "Joanne", "imageUrl", "Rowling"),
			ImmutableMap.of("productId", "author-2", "productName", "Herman", "imageUrl", "Melville"),
			ImmutableMap.of("productId", "author-3", "productName", "Anne", "imageUrl", "Rice"));

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

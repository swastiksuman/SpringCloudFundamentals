package com.cloud.fundamentals.graphqlserver.query;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{
	public String firstQuery() {
		return "firstQuery";
	}
}

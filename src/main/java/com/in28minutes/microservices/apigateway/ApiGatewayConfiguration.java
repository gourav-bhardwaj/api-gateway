package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(r -> r.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(r -> r.path("/currency-conversion/**")
								.uri("lb://currency-conversion"))
				.route(r -> r.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion")).build();
	}

}

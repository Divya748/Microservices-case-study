package com.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(r->r.path("/adharapp/**")
				.uri("http://localhost:3001/"))
				.route(r->r.path("/customerservice/**")
				.uri("http://localhost:3000/"))
				.route(r->r.path("/pancardservice/**")
				.uri("http://localhost:3002/"))
				.build();
	}

}

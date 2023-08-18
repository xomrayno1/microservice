package com.app.CloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
//	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//	            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
//	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//	            .build());
//	}
	
//	@Bean
//	public RouteLocator reRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes().build();
//	}
//	
//	@Bean
//	public RouteLocator retailBankCircuitBreaker(RouteLocatorBuilder routeLocatorBuilder) {
//		return routeLocatorBuilder.routes()
//				.route(p -> p.path("/orders/*")
//						.filters(f -> f.circuitBreaker(config -> config.setName("retailBankCircuitBreaker")
//																		.setFallbackUri("forward:/orderServiceFallBack")))
//						.uri("lb://ORDER-SERVICE"))
//				.build();
//	}


}

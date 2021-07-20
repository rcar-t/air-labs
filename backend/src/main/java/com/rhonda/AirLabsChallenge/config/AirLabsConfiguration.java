package com.rhonda.AirLabsChallenge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AirLabsConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins("http://localhost:4200", "http://0.0.0.0/")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", 
					"Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
					"Access-Control-Request-Headers")
			.exposedHeaders("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
					"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
	}
}

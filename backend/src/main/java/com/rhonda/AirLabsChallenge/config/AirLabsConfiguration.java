package com.rhonda.AirLabsChallenge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AirLabsConfiguration implements WebMvcConfigurer {
	
	private static ApiConfig apiConfig;
	
	public AirLabsConfiguration(ApiConfig apiConfig) {
		AirLabsConfiguration.apiConfig = apiConfig;
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins(apiConfig.getConfigValue("frontend.url"))
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", 
					"Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
					"Access-Control-Request-Headers")
			.exposedHeaders("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
					"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
		
		System.out.println(apiConfig.getConfigValue("frontend.url"));
	}
}

package com.rhonda.AirLabsChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rhonda.AirLabsChallenge.config.ApiConfig;
import com.rhonda.AirLabsChallenge.repository.AirportRepository;

@SpringBootApplication
public class AirLabsChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirLabsChallengeApplication.class, args);
	}

}

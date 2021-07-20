package com.rhonda.AirLabsChallenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rhonda.AirLabsChallenge.controller.AirportController;

@SpringBootTest
class AirLabsChallengeApplicationTests {
	
	@Autowired
	private AirportController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

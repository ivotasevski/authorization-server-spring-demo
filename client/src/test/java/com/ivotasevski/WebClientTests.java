package com.ivotasevski;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@SpringBootTest
class WebClientTests {

	private static final String RESOURCE_URI = "http://127.0.0.1:8081/token-info";

	@Autowired
	private WebClient webClient;

	@Test
	void willConsumeOAuth2Resource() {
		String tokenInfo = webClient.get()
				.uri(RESOURCE_URI)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		Assertions.assertNotNull(tokenInfo);

	}

}

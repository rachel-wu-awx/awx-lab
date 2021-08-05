package com.airwallex.lab

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class RestfulClientDemoApplicationTests{


	@Autowired
	lateinit var   webClient: WebClientDemo
	@Test
	fun testWebClientRetrieveMessageList() {
		var list = webClient.retrieveMessageList();
		assertNotNull(list)
	}

}

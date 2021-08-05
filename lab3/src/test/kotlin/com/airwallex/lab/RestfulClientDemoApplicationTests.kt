package com.airwallex.lab

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import kotlin.random.Random


@SpringBootTest
class RestfulClientDemoApplicationTests{

	private val logger = LoggerFactory.getLogger(RestfulClientDemoApplicationTests::class.java)

	@Autowired
	lateinit var   webClient: WebClientDemo
	@Test
	fun testWebClientRetrieveMessageList() {
		var list = webClient.retrieveMessageList();
		assertNotNull(list)
	}


	@Test
	fun testWebClientPostMessageToList(){
		var message:Message = Message (id=null, text = "Test Message: ${Random.nextInt()}")
		webClient.postMessage(message)


		var messageList = webClient.retrieveMessageList()
		if(messageList != null){
			for(item in messageList){
				logger.info(item.text)
			}
		}


	}

}

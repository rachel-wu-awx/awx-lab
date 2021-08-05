package com.airwallex.lab

import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class WebClientDemo (
    private val webClient: WebClient){


    private val logger = LoggerFactory.getLogger(WebClientDemo::class.java)



    //Get list of objects from the payload of response
    fun retrieveMessageList(): List<Message>? =
        webClient.get()
            .uri { it.pathSegment("api", "message").build() }
            .retrieve()
            .bodyToMono(typeReference<List<Message>>())
            .block()

     fun postMessage(message: Message){

         var response = webClient.post()
            .uri{it.pathSegment("api", "message").build()}
           .bodyValue(message)
           .retrieve().bodyToMono(Message::class.java).
             block()





    }


    //TODO: access to a secured end point

}
inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}
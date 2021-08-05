package com.airwallex.lab

import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class WebClientDemo (
    private val webClient: WebClient){




    //Get list of objects from the payload of response
    fun retrieveMessageList(): List<Message>? =
        webClient.get()
            .uri { it.pathSegment("api", "message").build() }
            .retrieve()
            .bodyToMono(typeReference<List<Message>>())
            .block()

}
inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}
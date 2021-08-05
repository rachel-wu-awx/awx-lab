package com.airwallex.lab

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Configuration
class WebClientConfiguration {


    private val logger = LoggerFactory.getLogger(WebClientConfiguration::class.java)

    @Bean
    fun webClient(builder: WebClient.Builder,
        @Value("\${application.service.api.baseUrl}") baseUrl: String
    ): WebClient =
        builder
            .baseUrl(baseUrl)
            .filter(requestLoggerFilter())
            .filter(responseLoggerFilter())
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()


    fun requestLoggerFilter() = ExchangeFilterFunction.ofRequestProcessor {
        logger.info("Logging request: ${it.method()} ${it.url()}")

        Mono.just(it)
    }

    fun responseLoggerFilter() = ExchangeFilterFunction.ofResponseProcessor {
        logger.info("Response status code: ${it.statusCode()}")

        Mono.just(it)
    }
}
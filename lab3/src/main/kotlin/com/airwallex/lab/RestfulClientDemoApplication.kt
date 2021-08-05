package com.airwallex.lab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestfulClientDemoApplication

fun main(args: Array<String>) {
	runApplication<RestfulClientDemoApplication>(*args)
}

package com.example.lab3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class Lab3Application

fun main(args: Array<String>) {
	runApplication<Lab3Application>(*args)
}

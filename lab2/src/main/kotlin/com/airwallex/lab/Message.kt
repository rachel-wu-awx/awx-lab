package com.airwallex.lab


import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


data class Message( val id: String?, val text: String)

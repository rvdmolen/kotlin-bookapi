package com.codingmill.bookapi.web.services

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger { }

@Service
class GreetingService {

    @Value("\${message}")
    lateinit var message: String

    fun retrieveGreeting(name : String): String {
        logger.info { "GreetingService with name $name" }
        return "Hello $name, $message"
    }

}
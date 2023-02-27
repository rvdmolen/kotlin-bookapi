package com.codingmill.bookapi.web.controller

import com.codingmill.bookapi.web.services.GreetingService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger { }

@RestController
class GreetingController(private val greetingService: GreetingService) {

//    private val logger = KotlinLogging.logger {}
//    private val log = LoggerFactory.getLogger(GreetingController::class.java)


    @GetMapping("/hello/{name}")
    fun greetName(@PathVariable("name") name: String): String {
        logger.info { "GET greeting" }
        return greetingService.retrieveGreeting(name)
    }
}
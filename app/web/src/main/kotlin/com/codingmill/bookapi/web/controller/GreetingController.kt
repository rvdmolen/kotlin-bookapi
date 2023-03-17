package com.codingmill.bookapi.web.controller

import com.codingmill.bookapi.common.model.GreetDTO
import com.codingmill.bookapi.web.services.GreetingService
import mu.KotlinLogging
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

private val logger = KotlinLogging.logger { }

@RestController
@Validated
class GreetingController(private val greetingService: GreetingService) {

//    private val logger = KotlinLogging.logger {}
//    private val log = LoggerFactory.getLogger(GreetingController::class.java)


    @GetMapping("/hello/{name}")
    fun greetName(@PathVariable("name") name: String): String {
        logger.info { "GET greeting" }
        return greetingService.retrieveGreeting(name)
    }

    @PostMapping("/hello")
    fun greetWithBodyName(@RequestBody @Valid greetDTO: GreetDTO): String {
        logger.info { "POST greeting" }
        return greetingService.retrieveGreeting(greetDTO.message)
    }
}
package com.codingmill.bookapi.web.controller

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {

    @GetMapping("/hello/{name}")
    fun greetName(@PathVariable("name") name: String): String {
        return "Hello $name"
    }
}
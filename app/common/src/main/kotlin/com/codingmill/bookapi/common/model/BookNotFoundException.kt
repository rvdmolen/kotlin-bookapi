package com.codingmill.bookapi.common.model

import mu.KotlinLogging


class BookNotFoundException(message: String? = null) : RuntimeException(message) {
    init {
        val logger = KotlinLogging.logger { }
        logger.error  { " BookNotFoundException occurred: $message" }
    }
}
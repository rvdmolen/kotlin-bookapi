package com.codingmill.bookapi.common.model

import mu.KotlinLogging


class AuthorNotFoundException(message: String? = null) : RuntimeException(message) {
    init {
        val logger = KotlinLogging.logger { }
        logger.error  { " AuthorNotFoundException occurred: $message" }
    }
}
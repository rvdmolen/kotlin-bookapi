package com.codingmill.bookapi.common.model

import mu.KotlinLogging


class BookAPITechnicalException(message: String? = null, t : Throwable? = null) : Exception(message, t) {
    init {
        val logger = KotlinLogging.logger { }

        logger.error  { " BookAPITechnicalException occurred $message ${t?.message}" }
    }
}
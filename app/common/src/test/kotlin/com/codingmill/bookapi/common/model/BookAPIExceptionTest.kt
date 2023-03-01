package com.codingmill.bookapi.common.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class BookAPIExceptionTest {

    companion object {
        const val error = "something went wrong"
    }

    @Test
    fun `should throw exception with message and cause`() {
        Assertions.assertThrows(BookAPITechnicalException::class.java) { throw BookAPITechnicalException(error, Throwable("BOOM")) }
    }

    @Test
    fun `should throw exception with message`() {
        Assertions.assertThrows(BookAPITechnicalException::class.java) { throw BookAPITechnicalException(error) }
    }

    @Test
    fun `should throw exception with default`() {
        Assertions.assertThrows(BookAPITechnicalException::class.java) { throw BookAPITechnicalException() }
    }
}
package com.codingmill.bookapi.common.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GreetDTOTest {

    @Test
    fun `should create createBookDTO`() {
        val greetDTO = GreetDTO(1, "")
        Assertions.assertNotNull(greetDTO)
    }
}
package com.codingmill.bookapi.web.controller

import com.codingmill.bookapi.web.services.GreetingService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(GreetingController::class)
class GreetingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var greetingService: GreetingService

    @Test
    fun `test retrieving Greeting`() {
        whenever(greetingService.retrieveGreeting(any())).thenReturn("dummy")

        val name = "richard"
        mockMvc.get("/hello/$name").andExpect {
            status { isOk() }
            content {
                contentTypeCompatibleWith("text/plain")
                string("dummy")
            }
        }
    }
}
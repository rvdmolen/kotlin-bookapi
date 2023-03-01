package com.codingmill.bookapi.web.controller

import com.codingmill.bookapi.web.services.GreetingService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.kotlin.any
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
        given(greetingService.retrieveGreeting(any())).willAnswer { "dummy" }

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
package com.codingmill.bookapi.web.controller

import com.codingmill.bookapi.common.model.GreetDTO
import com.codingmill.bookapi.web.exceptionhandler.BookAPIError
import com.codingmill.bookapi.web.services.GreetingService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(GreetingController::class)
class GreetingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var greetingService: GreetingService

    @BeforeEach
    fun setup() {
        given(greetingService.retrieveGreeting(any())).willAnswer { "dummy" }
    }

    @Test
    fun `test retrieving Greeting`() {
        val name = "richard"
        mockMvc.get("/hello/$name").andExpect {
            status { isOk() }
            content {
                contentTypeCompatibleWith("text/plain")
                string("dummy")
            }
        }
    }

    @Test
    fun `test greeting with body`() {
        val input = GreetDTO(1, "Hello")

         mockMvc.post("/hello") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(input)
        }.andExpect {
            status { isOk() }
            content {
                contentTypeCompatibleWith("text/plain")
                string("dummy")
            }
        }
    }

    @Test
    fun `test greeting with body and empty body`() {
        val input = GreetDTO(1, "")

        mockMvc.post("/hello") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(input)
        }.andExpect {
            status { isBadRequest() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json(mapper.writeValueAsString(BookAPIError.BAD_REQUEST)) }
        }
    }
}
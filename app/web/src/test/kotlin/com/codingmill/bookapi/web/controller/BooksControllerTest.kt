package com.codingmill.bookapi.web.controller


import com.codingmill.bookapi.common.model.BookAPITechnicalException
import com.codingmill.bookapi.common.model.BookNotFoundException
import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import com.codingmill.bookapi.web.exceptionhandler.BookAPIError
import com.codingmill.bookapi.web.services.BooksService
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.willThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.StatusResultMatchers.*


@WebMvcTest(BooksController::class)
class BooksControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var bookService: BooksService

    @Test
    fun testCreateBook() {
        val input = getBook()
        val expectation = BookIdentifier(1)

        given(bookService.createBook(any())).willAnswer { expectation }

        mockMvc.post("/books") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(input)
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json(mapper.writeValueAsString(expectation)) }
        }
    }

    @Test
    fun testCreateBookValidationError() {
        given(bookService.createBook(any())).willAnswer { BookIdentifier(1) }
        mockMvc.post("/books") {
            contentType = MediaType.APPLICATION_JSON
            content = ""
        }.andExpect {
            status { isBadRequest() }
        }
    }

    @Test
    fun testCreateBookInternalServerError() {
        val input = getBook()
        val expectation = BookAPIError.TECHNICAL_SERVER_ERROR

        given(bookService.createBook(any())).willThrow { BookAPITechnicalException("BOOM!!") }
        mockMvc.post("/books") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(input)
        }.andExpect {
            status { isInternalServerError() }
            content { json(mapper.writeValueAsString(expectation)) }
        }
    }

    @Test
    fun testGetAllBooks() {
        given(bookService.getAllBooks()).willAnswer { listOf(getBook()) }
        mockMvc.get("/books").andExpect {
            status().isOk
        }
    }

    @Test
    fun testGetBookById() {
        given(bookService.getBookById(any())).willAnswer { getBook() }
        mockMvc.get("/books/1").andExpect {
            status().isOk
        }
    }

    @Test
    fun testGetBookNotFound() {
        val expectation = BookAPIError.BOOK_NOT_FOUND_ERROR
        given(bookService.getBookById(any())).willThrow { BookNotFoundException() }
        mockMvc.get("/books/10").andExpect {
            status { isNotFound() }
            content { json(mapper.writeValueAsString(expectation)) }
        }
    }

    @Test
    fun deleteBookById() {
        given(bookService.deleteBookById(any())).willAnswer { }
        mockMvc.delete("/books/1").andExpect {
            status().isOk
        }
    }

    private fun getBook() = Book(
        id = -1,
        name = "test book",
        author = "john",
        isbn = "1234-1234",
        category = "development"
    )



}
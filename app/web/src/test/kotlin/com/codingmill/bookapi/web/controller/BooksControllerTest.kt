package com.codingmill.bookapi.web.controller


import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import com.codingmill.bookapi.web.services.BooksService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(BooksController::class)
class BooksControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var bookService: BooksService

    @Test
    fun testCreateBook() {
        given(bookService.createBook(any())).willAnswer { BookIdentifier(1) }
        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content("")).andExpect {
            status().isOk
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
    fun deleteBookById() {
        given(bookService.deleteBookById(any())).willAnswer { }
        mockMvc.delete("/books/1").andExpect {
            status().isOk
        }
    }

    private fun getBook() = Book(
        id = -1,
        name = "test book",
        author = "wim",
        isbn = "1234-1234",
        category = "development"
    )

}
package com.codingmill.bookapi.it

import com.codingmill.bookapi.generated.data.BookDTO
import com.codingmill.bookapi.generated.data.BookIdentifierDTO
import com.codingmill.bookapi.web.exceptionhandler.BookAPIError
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import com.codingmill.bookapi.generated.data.ErrorDTO

class BooksList : MutableList<BookDTO> by ArrayList()

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class BookapiApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    @Order(1)
    fun `test retrieving Greeting`() {
        val name = "richard"
        val result = restTemplate.getForEntity("/hello/$name", String::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals("Hello $name, Hello from the default profile", result.body) },
            { Assertions.assertEquals(HttpStatus.OK, result?.statusCode) }
        )
    }

    @Test
    @Order(2)
    fun `test create book`() {
        val book = getBook()
        val result = restTemplate.postForEntity("/books", book, BookIdentifierDTO::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals(1, result.body?.id) },
            { Assertions.assertEquals(HttpStatus.OK, result?.statusCode) }
        )
    }


    @Test
    @Order(3)
    fun `get books`() {
        val book = getBook()
        val result = restTemplate.getForEntity("/books", BooksList::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals(1, result?.body?.size) },
            { Assertions.assertEquals(book.name, result?.body?.first()?.name) },
            { Assertions.assertEquals(HttpStatus.OK, result?.statusCode) }
        )
    }

    @Test
    @Order(4)
    fun `get book by id`() {
        val book = getBook()
        val result = restTemplate.getForEntity("/books/1", BookDTO::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals(HttpStatus.OK, result?.statusCode) },
            { Assertions.assertEquals(book.name, result?.body?.name) }
        )
    }

    @Test
    fun `get book by id failure`() {
        val expectation = BookAPIError.BOOK_NOT_FOUND_ERROR
        val result = restTemplate.getForEntity("/books/999", Error::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals(HttpStatus.NOT_FOUND, result?.statusCode) },
            { Assertions.assertEquals(expectation.message , result?.body?.message) }
        )
    }

    @Test
    @Order(6)
    fun `delete book by id`() {
        val result = restTemplate.delete("/books/1");
        Assertions.assertNotNull(result)
    }

    private fun getBook() = BookDTO(
        id = -1,
        name = "test book",
        author = 1,
        isbn = "1234-1234",
        category = "development"
    )

}

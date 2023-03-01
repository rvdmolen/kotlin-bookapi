package com.codingmill.bookapi.it

import com.codingmill.bookapi.generated.data.Book
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus


class BooksList : MutableList<Book> by ArrayList()

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
        Assertions.assertNotNull(result)
        Assertions.assertEquals("Hello $name, Hello from the default profile", result.body)
        Assertions.assertEquals(HttpStatus.OK, result?.statusCode)
    }

    @Test
    @Order(2)
    fun `test create book`() {
        val book = getBook()
        val result = restTemplate.postForEntity("/books", book, String::class.java)

        Assertions.assertNotNull(result)
        Assertions.assertEquals("{\"id\":1}", result.body)
        Assertions.assertEquals(HttpStatus.OK, result?.statusCode)
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
        val result = restTemplate.getForEntity("/books/1", Book::class.java)
        Assertions.assertAll(
            { Assertions.assertNotNull(result) },
            { Assertions.assertEquals(HttpStatus.OK, result?.statusCode) },
            { Assertions.assertEquals(book.name, result?.body?.name) }
        )
    }

    @Test
    @Order(5)
    fun `delete book by id`() {
        val result = restTemplate.delete("/books/1");
        Assertions.assertNotNull(result)
    }

    private fun getBook() = Book(
        id = -1,
        name = "test book",
        author = "wim",
        isbn = "1234-1234",
        category = "development"
    )

}

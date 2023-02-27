package com.codingmill.bookapi

import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import mu.KLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BookapiApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun contextLoads() {
    }


    @Test
    fun `test retrieving Greeting`() {
        val name = "richard"
        val result = restTemplate.getForEntity("/hello/$name", String::class.java);
        Assertions.assertNotNull(result)
        Assertions.assertEquals("Hello $name, Hello from the default profile", result.body)
        Assertions.assertEquals(HttpStatus.OK, result?.statusCode)
    }

    @Test
    fun `test create book`() {
        val book : Book = Book(
            id = -1,
            name = "test book",
            author = "wim",
            isbn = "1234-1234",
            category = "development"
        )

        val result = restTemplate.postForEntity("/books", book, String::class.java);

        Assertions.assertNotNull(result)
        Assertions.assertEquals("{\"id\":1}", result.body)
        Assertions.assertEquals(HttpStatus.OK, result?.statusCode)
    }

}

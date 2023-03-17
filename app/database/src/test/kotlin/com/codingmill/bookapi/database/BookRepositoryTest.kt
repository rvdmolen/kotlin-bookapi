package com.codingmill.bookapi.database

import com.codingmill.bookapi.database.builders.BookEntityBuilder
import com.codingmill.bookapi.database.entity.BookEntity
import com.codingmill.bookapi.database.repository.BookRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class BookRepositoryTest {


//    @Autowired
//    lateinit var entityManager : TestEntityManager

    @Autowired
    lateinit var bookRepository: BookRepository;

    @BeforeEach
    fun setUp() {
        bookRepository.deleteAll()
        val books = listOf(
            makeBook("Test the beginning", "Wim"),
            makeBook("Test the end", "Bob"),
            makeBook("Another Book", "John"),
        )
        bookRepository.saveAll(books)
    }

    @Test
    fun findByNameContaining() {
        val books = bookRepository.findByNameContaining("the")
        println(books)
        Assertions.assertEquals(2, books.size)
    }

    private fun makeBook(name: String, author: String) = BookEntityBuilder.Builder()
        .name(name)
        .author(author)
        .isbn("")
        .category("development")
        .build()
}
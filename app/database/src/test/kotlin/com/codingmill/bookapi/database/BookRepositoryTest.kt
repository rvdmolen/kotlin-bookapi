package com.codingmill.bookapi.database

import com.codingmill.bookapi.database.builders.AuthorEntityBuilder
import com.codingmill.bookapi.database.builders.BookEntityBuilder
import com.codingmill.bookapi.database.entity.Author
import com.codingmill.bookapi.database.entity.Book
import com.codingmill.bookapi.database.repository.AuthorRepository
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

    @Autowired
    lateinit var authorRepository: AuthorRepository;

    @BeforeEach
    fun setUp() {
        bookRepository.deleteAll()

        val books = listOf(
            makeBook("Test the beginning", makeAuthor(1,"John")),
            makeBook("Test the end", makeAuthor(2, "William")),
            makeBook("Another Book", makeAuthor(3, "Richard")),
        )
        bookRepository.saveAll(books)
    }

    @Test
    fun findByNameContaining() {
        val books = bookRepository.findByNameContaining("Test")
        Assertions.assertEquals(2, books.size)
    }

    @Test
    fun findByCustomNameContaining() {
        val books = bookRepository.findAllBooksByCustomName("Test")
        Assertions.assertEquals(2, books.size)
    }

    @Test
    fun authorsShouldBePresentOnStart() {
        val authors = authorRepository.findAll()
        Assertions.assertEquals(5, authors.count())
    }

    private fun makeBook(name: String, author: Author) = BookEntityBuilder.Builder()
        .name(name)
        .author(author)
        .isbn("")
        .category("development")
        .build()

    private fun makeAuthor(id: Long, name: String) = AuthorEntityBuilder.Builder()
        .authorId(id)
        .name("John")
        .build()
}
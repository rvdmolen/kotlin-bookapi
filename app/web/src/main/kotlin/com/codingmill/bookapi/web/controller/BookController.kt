package com.codingmill.bookapi.web.controller


import com.codingmill.bookapi.generated.controller.BooksApi
import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import com.codingmill.bookapi.web.services.BooksService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController


private val logger = KotlinLogging.logger { }


@RestController
class BooksController(val booksService: BooksService) : BooksApi {

    override fun listBooks(limit: Int?): ResponseEntity<List<Book>> {
        logger.info { "GET all books" }
        val result = emptyList<Book>()
        return ResponseEntity.ok().body(result);
    }

    override fun addBook(book: Book): ResponseEntity<BookIdentifier> {
        logger.info { "POST create book" }
        val result = booksService.createBook(book)
        return ResponseEntity.ok().body(result);
    }


}
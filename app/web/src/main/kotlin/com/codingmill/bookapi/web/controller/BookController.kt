package com.codingmill.bookapi.web.controller


import com.codingmill.bookapi.generated.controller.BooksApi
import com.codingmill.bookapi.generated.data.BookDTO
import com.codingmill.bookapi.generated.data.BookIdentifierDTO
import com.codingmill.bookapi.web.services.BooksService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController


private val logger = KotlinLogging.logger { }


@RestController
class BooksController(val booksService: BooksService) : BooksApi {

    override fun listBooks(limit: Int?): ResponseEntity<List<BookDTO>> {
        logger.info { "GET all books" }
        val result = booksService.getAllBooks()
        return ResponseEntity.ok().body(result)
    }

    override fun addBook(bookDTO: BookDTO): ResponseEntity<BookIdentifierDTO> {
        logger.info { "POST create book" }
        val result = booksService.createBook(bookDTO)
        return ResponseEntity.ok().body(result)
    }

    override fun showBookById(bookId: String): ResponseEntity<BookDTO> {
        logger.info { "GET book by id" }
        val result = booksService.getBookById(bookId)
        return ResponseEntity.ok().body(result)
    }

    override fun deleteBookById(bookId: String): ResponseEntity<Unit> {
        logger.info { "DELETE book" }
        booksService.deleteBookById(bookId)
        return ResponseEntity.noContent().build()
    }
}
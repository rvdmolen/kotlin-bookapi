package com.codingmill.bookapi.web.services

import com.codingmill.bookapi.common.model.BookAPITechnicalException
import com.codingmill.bookapi.common.model.BookNotFoundException
import com.codingmill.bookapi.database.repository.BookRepository
import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import com.codingmill.bookapi.web.mappers.mapToBook
import com.codingmill.bookapi.web.mappers.mapToBookEntity
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger { }

@Service
class BooksService(val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> =
        bookRepository.findAll()
            .map { mapToBook(it) }


    fun getBookById(bookId: String): Book =
        bookRepository.findById(bookId.toLong())
            .map { mapToBook(it) }
            .orElseThrow { BookNotFoundException("Book with id $bookId is not found") }

    fun deleteBookById(bookId: String): Unit =
        bookRepository.findById(bookId.toLong())
            .map(bookRepository::delete)
            .orElseThrow { BookNotFoundException("Book with id $bookId is not found") }


    fun createBook(book: Book) =
        bookRepository.save(mapToBookEntity(book)).let {
            when (it.id) {
                null -> {
                    logger.error { "Failed to create book" }
                    throw BookAPITechnicalException("Failed to create book")
                }
                else -> {
                    logger.info { "Book is saved with id: $it.id" }
                    BookIdentifier(it.id!!)
                }
            }
        }
}

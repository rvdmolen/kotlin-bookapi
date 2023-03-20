package com.codingmill.bookapi.web.services

import com.codingmill.bookapi.common.model.AuthorNotFoundException
import com.codingmill.bookapi.common.model.BookAPITechnicalException
import com.codingmill.bookapi.common.model.BookNotFoundException
import com.codingmill.bookapi.database.repository.AuthorRepository
import com.codingmill.bookapi.database.repository.BookRepository
import com.codingmill.bookapi.generated.data.BookDTO
import com.codingmill.bookapi.generated.data.BookIdentifierDTO
import com.codingmill.bookapi.web.mappers.mapToBook
import com.codingmill.bookapi.web.mappers.mapToBookEntity
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger { }

@Service
class BooksService(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository
) {

    fun getAllBooks(): List<BookDTO> =
        bookRepository.findAll()
            .map { mapToBook(it) }


    fun getBookById(bookId: String): BookDTO =
        bookRepository.findById(bookId.toLong())
            .map { mapToBook(it) }
            .orElseThrow { BookNotFoundException("Book with id $bookId is not found") }

    fun deleteBookById(bookId: String): Unit =
        bookRepository.findById(bookId.toLong())
            .map(bookRepository::delete)
            .orElseThrow { BookNotFoundException("Book with id $bookId is not found") }


    fun createBook(bookDTO: BookDTO): BookIdentifierDTO =
        authorRepository.findById(bookDTO.author)
            .map {
                bookRepository.save(mapToBookEntity(bookDTO)).let {
                    when (it.bookId) {
                        null -> {
                            logger.error { "Failed to create book" }
                            throw BookAPITechnicalException("Failed to create book")
                        }

                        else -> {
                            logger.info { "Book is saved with id: $it.id" }
                            BookIdentifierDTO(it.bookId!!)
                        }
                    }
                }
            }
            .orElseThrow { AuthorNotFoundException("Author with id $bookDTO.author is not found") }
}


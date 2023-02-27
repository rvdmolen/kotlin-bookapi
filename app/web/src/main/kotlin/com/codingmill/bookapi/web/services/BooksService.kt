package com.codingmill.bookapi.web.services

import com.codingmill.bookapi.database.entity.BookEntity
import com.codingmill.bookapi.database.repository.BookRepository
import com.codingmill.bookapi.generated.data.Book
import com.codingmill.bookapi.generated.data.BookIdentifier
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger { }
@Service
class BooksService(val bookRepository: BookRepository) {
    fun createBook(book: Book) =
        bookRepository.save(mapToBookEntity(book)).let {
            if (it.id == null) {
                logger.error { "Failed to create book" }
                throw Exception("Invalid")
            }
            logger.info { "Book is saved with id: $it.id" }
            BookIdentifier(it.id!!)
        }

    fun mapToBookEntity(bookDTO: Book) =
        BookEntity(
            id = bookDTO.id,
            name = bookDTO.name,
            author = bookDTO.author,
            category = bookDTO.category,
            isbn = bookDTO.isbn
        )
}

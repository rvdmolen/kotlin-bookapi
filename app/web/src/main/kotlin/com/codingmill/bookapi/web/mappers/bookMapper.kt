package com.codingmill.bookapi.web.mappers

import com.codingmill.bookapi.database.entity.Author
import com.codingmill.bookapi.database.entity.Book
import com.codingmill.bookapi.generated.data.BookDTO

fun mapToBookEntity(bookDTO: BookDTO) =
    Book(
        bookId = bookDTO.id,
        name = bookDTO.name,
        author = Author(bookDTO.author),
        category = bookDTO.category,
        isbn = bookDTO.isbn
    )


fun mapToBook(book: Book) =
    BookDTO(
        id = book.let { it.bookId ?: -1L },
        name = book.name,
        author = book.author.let { it?.authorId ?: -1L },
        category = book.category,
        isbn = book.isbn
    )
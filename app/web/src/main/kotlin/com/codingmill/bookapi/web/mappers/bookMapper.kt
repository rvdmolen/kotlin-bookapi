package com.codingmill.bookapi.web.mappers

import com.codingmill.bookapi.database.entity.BookEntity
import com.codingmill.bookapi.generated.data.Book

fun mapToBookEntity(book: Book) =
    BookEntity(
        id = book.id,
        name = book.name,
        author = book.author,
        category = book.category,
        isbn = book.isbn
    )


fun mapToBook(bookEntity: BookEntity) =
    Book(
        id = bookEntity.let { it.id ?: -1L },
        name = bookEntity.name,
        author = bookEntity.author,
        category = bookEntity.category,
        isbn = bookEntity.isbn
    )
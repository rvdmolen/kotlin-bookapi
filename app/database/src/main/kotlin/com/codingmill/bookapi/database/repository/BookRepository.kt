package com.codingmill.bookapi.database.repository

import com.codingmill.bookapi.database.entity.BookEntity
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookEntity, Long> {



}
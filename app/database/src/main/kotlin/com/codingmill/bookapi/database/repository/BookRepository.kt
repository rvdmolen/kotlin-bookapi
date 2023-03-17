package com.codingmill.bookapi.database.repository

import com.codingmill.bookapi.database.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository : CrudRepository<BookEntity, Long> {


    fun findByNameContaining(bookName: String) : List<BookEntity>
}
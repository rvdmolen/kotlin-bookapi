package com.codingmill.bookapi.database.repository

import com.codingmill.bookapi.database.entity.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository : CrudRepository<Book, Long> {


    fun findByNameContaining(bookName: String) : List<Book>


    @Query(value = "SELECT * from BOOKS where name like %?1%", nativeQuery = true)
    fun findAllBooksByCustomName(bookName: String): List<Book>

}
package com.codingmill.bookapi.database.repository

import com.codingmill.bookapi.database.entity.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface AuthorRepository : CrudRepository<Author, Long> {

}
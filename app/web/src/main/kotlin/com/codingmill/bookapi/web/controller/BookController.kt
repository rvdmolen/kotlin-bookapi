package com.codingmill.bookapi.web.controller


import com.codingmill.bookapi.generated.controller.BooksApi
import com.codingmill.bookapi.generated.data.Book
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class BooksController : BooksApi {
    override fun listBooks(limit: Int?): ResponseEntity<List<Book>> {
        val result = emptyList<Book>()
        return ResponseEntity.ok().body(result);
    }


//    override fun listBooks(limit: Int?): ResponseEntity<List<Book>> {
//        val result = emptyList<Book>()
//        return ResponseEntity.ok().body(result);
//    }


}
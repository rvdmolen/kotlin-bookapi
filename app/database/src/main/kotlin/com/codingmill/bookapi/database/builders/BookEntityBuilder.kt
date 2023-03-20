package com.codingmill.bookapi.database.builders

import com.codingmill.bookapi.database.entity.Author
import com.codingmill.bookapi.database.entity.Book

class BookEntityBuilder(var name: String) {

    data class Builder(
        var name: String? = null,
        var author: Author? = null,
        var isbn: String? =  null,
        var category: String? =  null
    ) {
        fun build() = Book(-1, name!!, author!!, isbn!!, category!!)
        fun name(name: String) = apply { this.name = name }
        fun author(author: Author) = apply { this.author = author }
        fun isbn(isbn: String) = apply { this.isbn = isbn }
        fun category(category: String) = apply { this.category = category }
    }
}
package com.codingmill.bookapi.database.builders

import com.codingmill.bookapi.database.entity.BookEntity

class BookEntityBuilder(var name: String) {

    data class Builder(
        var name: String? = null,
        var author: String? = null,
        var isbn: String? =  null,
        var category: String? =  null
    ) {
        fun build() = BookEntity(-1, name!!, author!!, isbn!!, category!!)
        fun name(name: String) = apply { this.name = name }
        fun author(author: String) = apply { this.author = author }
        fun isbn(isbn: String) = apply { this.isbn = isbn }
        fun category(category: String) = apply { this.category = category }
    }
}
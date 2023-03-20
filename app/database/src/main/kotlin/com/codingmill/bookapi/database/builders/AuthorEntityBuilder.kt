package com.codingmill.bookapi.database.builders

import com.codingmill.bookapi.database.entity.Author

class AuthorEntityBuilder(var name: String) {

    data class Builder(
        var id: Long? = null,
        var name: String? = null,
    ) {
        fun build() = Author(id, name!!)
        fun name(name: String) = apply { this.name = name }
        fun authorId(id: Long) = apply { this.id = id }

    }
}
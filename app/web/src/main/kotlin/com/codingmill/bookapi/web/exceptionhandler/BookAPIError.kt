package com.codingmill.bookapi.web.exceptionhandler

import com.codingmill.bookapi.generated.data.ErrorDTO


class BookAPIError {
    companion object {
        val BAD_REQUEST = ErrorDTO(1, "Bad argument")
        val TECHNICAL_SERVER_ERROR = ErrorDTO(2, "Internal server error from BookAPI")
        val BOOK_NOT_FOUND_ERROR = ErrorDTO(3, "Book not found")
            val AUTHOR_NOT_FOUND_ERROR = ErrorDTO(4, "Author not found")
    }
}
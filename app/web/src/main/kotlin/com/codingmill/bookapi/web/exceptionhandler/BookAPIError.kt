package com.codingmill.bookapi.web.exceptionhandler

import com.codingmill.bookapi.generated.data.Error


class BookAPIError {
    companion object {
        val BAD_REQUEST = Error(1, "Bad argument")
        val TECHNICAL_SERVER_ERROR = Error(2, "Internal server error from BookAPI")
        val BOOK_NOT_FOUND_ERROR = Error(2, "Book not found")
    }
}
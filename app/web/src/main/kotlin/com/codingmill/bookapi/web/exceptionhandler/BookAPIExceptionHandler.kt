package com.codingmill.bookapi.web.exceptionhandler

import com.codingmill.bookapi.common.model.AuthorNotFoundException
import com.codingmill.bookapi.common.model.BookAPITechnicalException
import com.codingmill.bookapi.common.model.BookNotFoundException
import mu.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

private val logger = KotlinLogging.logger { }

@Component
@ControllerAdvice
class BookAPIExceptionHandler : ResponseEntityExceptionHandler() {


    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        logger.error("MethodArgumentNotValidException observed : ${ex.message}")
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(BookAPIError.BAD_REQUEST)
    }

    @ExceptionHandler(BookAPITechnicalException::class)
    fun handleBookAPITechnicalException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        logger.error("BookAPITechnicalException observed : ${ex.message}")
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BookAPIError.TECHNICAL_SERVER_ERROR)
    }

    @ExceptionHandler(BookNotFoundException::class)
    fun handleBookNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        logger.error("BookNotFoundException observed : ${ex.message}")
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(BookAPIError.BOOK_NOT_FOUND_ERROR)
    }

    @ExceptionHandler(AuthorNotFoundException::class)
    fun handleAuthorNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        logger.error("AuthorNotFoundException observed : ${ex.message}")
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(BookAPIError.AUTHOR_NOT_FOUND_ERROR)
    }


}


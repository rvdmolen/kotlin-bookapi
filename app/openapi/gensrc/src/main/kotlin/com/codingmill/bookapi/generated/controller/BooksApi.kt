/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package com.codingmill.bookapi.generated.controller

import com.codingmill.bookapi.generated.data.BookDTO
import com.codingmill.bookapi.generated.data.BookIdentifierDTO
import com.codingmill.bookapi.generated.data.ErrorDTO
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@Validated
@RequestMapping("\${api.base-path:}")
interface BooksApi {

    @Operation(
        summary = "Create a book",
        operationId = "addBook",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "Id of the new book", content = [Content(schema = Schema(implementation = BookIdentifierDTO::class))]),
            ApiResponse(responseCode = "200", description = "unexpected error", content = [Content(schema = Schema(implementation = ErrorDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/books"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun addBook(@Parameter(description = "", required = true) @Valid @RequestBody bookDTO: BookDTO): ResponseEntity<BookIdentifierDTO> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Delete a specific book",
        operationId = "deleteBookById",
        description = "",
        responses = [
            ApiResponse(responseCode = "204", description = "No Content"),
            ApiResponse(responseCode = "200", description = "unexpected error", content = [Content(schema = Schema(implementation = ErrorDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.DELETE],
            value = ["/books/{bookId}"],
            produces = ["application/json"]
    )
    fun deleteBookById(@Parameter(description = "The id of the book to retrieve", required = true) @PathVariable("bookId") bookId: kotlin.String): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "List all books",
        operationId = "listBooks",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of books", content = [Content(schema = Schema(implementation = BookDTO::class))]),
            ApiResponse(responseCode = "200", description = "unexpected error", content = [Content(schema = Schema(implementation = ErrorDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/books"],
            produces = ["application/json"]
    )
    fun listBooks(@Parameter(description = "How many items to return at one time (max 100)") @Valid @RequestParam(value = "limit", required = false) limit: kotlin.Int?): ResponseEntity<List<BookDTO>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Info for a specific book",
        operationId = "showBookById",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = [Content(schema = Schema(implementation = BookDTO::class))]),
            ApiResponse(responseCode = "200", description = "unexpected error", content = [Content(schema = Schema(implementation = ErrorDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/books/{bookId}"],
            produces = ["application/json"]
    )
    fun showBookById(@Parameter(description = "The id of the book to retrieve", required = true) @PathVariable("bookId") bookId: kotlin.String): ResponseEntity<BookDTO> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}

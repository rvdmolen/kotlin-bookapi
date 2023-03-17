package com.codingmill.bookapi.common.model

import javax.validation.constraints.NotBlank


data class GreetDTO(
    val id: Int,

    @get:NotBlank(message = "message should not be blank")
    val message: String
)
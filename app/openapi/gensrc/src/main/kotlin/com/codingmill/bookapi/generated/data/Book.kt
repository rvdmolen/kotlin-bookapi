package com.codingmill.bookapi.generated.data

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param name 
 * @param tag 
 */
data class Book(

    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("id", required = true) val id: kotlin.Long,

    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(example = "null", description = "")
    @field:JsonProperty("tag") val tag: kotlin.String? = null
) {

}


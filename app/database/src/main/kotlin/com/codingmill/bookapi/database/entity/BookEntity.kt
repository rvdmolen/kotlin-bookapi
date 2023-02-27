package com.codingmill.bookapi.database.entity

import javax.persistence.*

@Entity
@Table(name = "Books")
data class BookEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? =  null,

    val name: String = "",
    val author : String = "",
    val isbn: String = "",
    val category: String = ""
)
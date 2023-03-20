package com.codingmill.bookapi.database.entity

import javax.persistence.*

@Entity
@Table(name = "Authors")
data class Author (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val authorId: Long? =  null,

    val name: String = "",

    //var books : List<BookEntity> = mutableListOf()
)
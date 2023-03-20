package com.codingmill.bookapi.database.entity

import javax.persistence.*

@Entity
@Table(name = "Books")
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val bookId: Long? =  null,

    val name: String = "",

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "authorId", nullable = false)
    val author : Author? = null,

    val isbn: String = "",
    val category: String = ""
)
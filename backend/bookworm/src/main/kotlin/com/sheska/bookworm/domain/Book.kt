package com.sheska.bookworm.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Book(
    @Id
    val isbn: Long,
    var title: String,
    var author: String,
    var publisher: String,
    var saga: String?,
    var tags: List<String>)
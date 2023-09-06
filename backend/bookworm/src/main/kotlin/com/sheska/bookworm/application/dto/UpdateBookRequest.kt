package com.sheska.bookworm.application.dto

data class UpdateBookRequest(val isbn: Long, var title: String, var author: String, var publisher: String, var saga: String, var tags: List<String>)
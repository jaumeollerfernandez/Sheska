package com.sheska.bookworm.application.transformer

import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.domain.Book

fun Book?.toBookResponse(): BookResponse{
    return BookResponse(
        isbn = this?.isbn ?: 1L,
        title = this?.title ?: "Not found title.",
        author = this?.author ?: "",
        publisher = this?.publisher ?: "",
        saga = this?.saga ?: "",
        tags = this?.tags ?: mutableListOf("").toList(),
    )
}
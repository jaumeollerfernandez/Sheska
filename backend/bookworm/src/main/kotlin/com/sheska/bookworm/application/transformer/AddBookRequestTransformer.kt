package com.sheska.bookworm.application.transformer

import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.domain.Book
import org.springframework.stereotype.Component

@Component
class AddBookRequestTransformer:Transformer<AddBookRequest, Book> {
    override fun transform(source: AddBookRequest): Book {
        return Book(
            isbn = source.isbn,
            title = source.title,
            author = source.author,
            publisher = source.publisher,
            saga = source.saga,
            tags = source.tags
        )
    }
}
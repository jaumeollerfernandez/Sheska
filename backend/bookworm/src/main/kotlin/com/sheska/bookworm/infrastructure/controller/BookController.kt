package com.sheska.bookworm.infrastructure.controller

import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.application.dto.UpdateBookRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.function.EntityResponse

interface BookController {
    fun findByISBN(isbn: Long): ResponseEntity<BookResponse>?
    fun findAll(): ResponseEntity<List<BookResponse>>
    fun save(addBookRequest: AddBookRequest): ResponseEntity<BookResponse>
    fun update(updateBookRequest: UpdateBookRequest): ResponseEntity<BookResponse>
    fun deleteByISBN(isbn: Long): ResponseEntity<Unit>
}
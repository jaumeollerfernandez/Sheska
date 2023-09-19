package com.sheska.bookworm.application.service

import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.application.dto.UpdateBookRequest

interface BookManagementService {
    fun findByISBN(isbn: Long):BookResponse?
    fun findAll(): List<BookResponse>
    fun save(addBookRequest: AddBookRequest):BookResponse
    fun update(updateBookRequest: UpdateBookRequest): BookResponse
    fun deleteByISBN(isbn: Long): Unit
}
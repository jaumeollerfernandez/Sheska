package com.sheska.bookworm.infrastructure.controller

import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.application.dto.UpdateBookRequest
import com.sheska.bookworm.application.service.BookManagementService
import com.sheska.bookworm.infrastructure.controller.BookControllerImpl.Companion.BASE_BOOK_URL
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [BASE_BOOK_URL])
class BookControllerImpl(private val bookManagementService: BookManagementService) : BookController {
    @GetMapping("/{id}")
    override fun findByISBN(@PathVariable isbn: Long): ResponseEntity<BookResponse>? {
        val bookResponse = this.bookManagementService.findByISBN(isbn)

    }

    override fun findAll(): ResponseEntity<List<BookResponse>> {
        TODO("Not yet implemented")
    }

    override fun save(addBookRequest: AddBookRequest): ResponseEntity<BookResponse> {
        TODO("Not yet implemented")
    }

    override fun update(updateBookRequest: UpdateBookRequest): ResponseEntity<BookResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteByISBN(isbn: Long): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    companion object{
        const val BASE_BOOK_URL: String = "/api/v1/book"
    }
}
package com.sheska.bookworm.infrastructure.controller

import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.application.dto.UpdateBookRequest
import com.sheska.bookworm.application.service.BookManagementService
import com.sheska.bookworm.infrastructure.controller.BookControllerImpl.Companion.BASE_BOOK_URL
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_BOOK_URL])
class BookControllerImpl(private val bookManagementService: BookManagementService) : BookController {
    @GetMapping("/{isbn}")
    override fun findByISBN(@PathVariable isbn: Long): ResponseEntity<BookResponse>? {
        val bookResponse: BookResponse? = this.bookManagementService.findByISBN(isbn)
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse)
    }
    @GetMapping("")
    override fun findAll(): ResponseEntity<List<BookResponse>> {
        val listOfBooks = this.bookManagementService.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(listOfBooks)
    }
    @PostMapping
    override fun save(@RequestBody addBookRequest: AddBookRequest): ResponseEntity<BookResponse> {
        val bookResponse = this.bookManagementService.save(addBookRequest)
        return ResponseEntity.created(URI.create(BASE_BOOK_URL.plus("/${bookResponse.isbn}"))).body(bookResponse)
    }
    @PutMapping
    override fun update(@RequestBody updateBookRequest: UpdateBookRequest): ResponseEntity<BookResponse> {
        return ResponseEntity.ok(this.bookManagementService.update(updateBookRequest))
    }

    @DeleteMapping("{isbn}")
    override fun deleteByISBN(@PathVariable isbn: Long): ResponseEntity<Unit> {
        this.bookManagementService.deleteByISBN(isbn)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_BOOK_URL: String = "/api/v1/book"
    }
}
package com.sheska.bookworm.application.service

import com.sheska.bookworm.application.dao.BookDao
import com.sheska.bookworm.application.dto.AddBookRequest
import com.sheska.bookworm.application.dto.BookResponse
import com.sheska.bookworm.application.dto.UpdateBookRequest
import com.sheska.bookworm.application.transformer.AddBookRequestTransformer
import com.sheska.bookworm.application.transformer.toBookResponse
import com.sheska.bookworm.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class BookManagementServiceImpl(@Autowired private val bookDao: BookDao, addBookRequestTransformer: AddBookRequestTransformer) : BookManagementService {
    override fun findByISBN(isbn: Long): BookResponse? {
        return this.findBookByISBN(isbn).toBookResponse()
    }

    override fun findAll(): BookResponse {
        TODO("Not yet implemented")
    }

    override fun save(addBookRequest: AddBookRequest): BookResponse {
        TODO("Not yet implemented")
    }

    override fun update(updateBookRequest: UpdateBookRequest): BookResponse {
        TODO("Not yet implemented")
    }

    override fun deleteByISBN(isbn: Long) {
        TODO("Not yet implemented")
    }

    private fun findBookByISBN(isbn: Long): Book? {
        return this.bookDao.findByIdOrNull(isbn)
    }
}
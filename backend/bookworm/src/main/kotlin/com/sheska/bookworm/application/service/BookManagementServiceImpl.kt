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

class BookManagementServiceImpl(@Autowired private val bookDao: BookDao, val addBookRequestTransformer: AddBookRequestTransformer) : BookManagementService {
    override fun findByISBN(isbn: Long): BookResponse? {
        return this.findBookByISBN(isbn).toBookResponse()
    }

    override fun findAll(): List<BookResponse> {
        return this.bookDao.findAll().map(Book::toBookResponse)
    }

    override fun save(addBookRequest: AddBookRequest): BookResponse {
        return this.saveOrUpdate(addBookRequestTransformer.transform(addBookRequest))
    }

    override fun update(updateBookRequest: UpdateBookRequest): BookResponse {
        val bookToFind = this.findBookByISBN(updateBookRequest.isbn) ?: throw IllegalStateException("${updateBookRequest.isbn} not found.")
        return saveOrUpdate( bookToFind.apply{
            this.title = updateBookRequest.title
            this.author = updateBookRequest.author
            this.publisher = updateBookRequest.publisher
            this.saga = updateBookRequest.saga
            this.tags = updateBookRequest.tags
        })
    }

    override fun deleteByISBN(isbn: Long) {
        this.bookDao.deleteById(isbn)
    }

    private fun findBookByISBN(isbn: Long): Book? {
        return this.bookDao.findByIdOrNull(isbn)
    }

    private fun saveOrUpdate(book: Book): BookResponse{
        return this.bookDao.save(book).toBookResponse()
    }
}
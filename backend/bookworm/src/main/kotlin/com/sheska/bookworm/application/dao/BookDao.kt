package com.sheska.bookworm.application.dao

import com.sheska.bookworm.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao: JpaRepository<Book, Long>{
}
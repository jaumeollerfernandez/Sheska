package com.sheska.bookworm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookwormApplication

fun main(args: Array<String>) {
	runApplication<BookwormApplication>(*args)
}

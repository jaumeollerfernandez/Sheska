package com.sheska.bookworm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class BookwormApplication{
	@GetMapping
	fun test():String{
		return "It works"
	}
}

fun main(args: Array<String>) {
	runApplication<BookwormApplication>(*args)
}

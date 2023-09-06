package com.sheska.bookworm.application.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}
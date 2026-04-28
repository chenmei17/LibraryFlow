package com.ch.libraryflow.book.dto;

public record BookCreateRequest(
        String bookName,
        String author,
        String isbn
) {
}

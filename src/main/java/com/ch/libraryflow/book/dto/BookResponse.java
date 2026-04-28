package com.ch.libraryflow.book.dto;

import com.ch.libraryflow.book.domain.BookStatus;

public record BookResponse(
        Long bookId,
        String bookName,
        String author,
        String isbn,
        BookStatus bookStatus
) {
}

package com.ch.libraryflow.book.dto;

import java.util.List;

public record BookListResponse(
        List<BookResponse> bookList
) {
}

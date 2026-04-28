package com.ch.libraryflow.common.exception;

public class BookNotFoundException extends NotFoundException{
    public BookNotFoundException() {
        super(ErrorCode.BOOK_NOT_FOUND);
    }
}

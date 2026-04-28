package com.ch.libraryflow.common.exception;

public class BookAlreadyLoanedException extends BusinessException{
    public BookAlreadyLoanedException() {
        super(ErrorCode.BOOK_ALREADY_LOANED);
    }
}

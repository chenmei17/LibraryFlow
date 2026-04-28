package com.ch.libraryflow.common.exception;

public class DuplicateIsbnException extends BusinessException{
    public DuplicateIsbnException() {
        super(ErrorCode.DUPLICATE_ISBN);
    }
}

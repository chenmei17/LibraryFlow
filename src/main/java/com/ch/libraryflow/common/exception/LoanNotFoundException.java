package com.ch.libraryflow.common.exception;

public class LoanNotFoundException extends NotFoundException{
    public LoanNotFoundException() {
        super(ErrorCode.LOAN_NOT_FOUND);
    }
}

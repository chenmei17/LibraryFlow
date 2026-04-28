package com.ch.libraryflow.common.exception;

public class LoanAlreadyReturnedException extends BusinessException{
    public LoanAlreadyReturnedException() {
        super(ErrorCode.LOAN_ALREADY_RETURNED);
    }
}

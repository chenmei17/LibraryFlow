package com.ch.libraryflow.common.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException  extends RuntimeException {
    private final ErrorCode errorCode;

    protected ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }

}


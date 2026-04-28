package com.ch.libraryflow.common.exception;

import org.springframework.http.HttpStatus;

public abstract class BusinessException extends ApplicationException {

    protected BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }

}

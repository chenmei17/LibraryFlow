package com.ch.libraryflow.common.exception;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends ApplicationException {

    protected NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

}

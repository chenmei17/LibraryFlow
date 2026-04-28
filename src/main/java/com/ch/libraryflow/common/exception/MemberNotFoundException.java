package com.ch.libraryflow.common.exception;

public class MemberNotFoundException extends BusinessException{
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}

package com.ch.libraryflow.common.exception;

public enum ErrorCode {

    BOOK_NOT_FOUND("존재하지 않는 도서입니다."),

    MEMBER_NOT_FOUND("회원정보가 없습니다."),
    DUPLICATE_ISBN("이미 등록된 ISBN 코드입니다."),
    DUPLICATE_EMAIL("이미 등록된 email 입니다."),

    BOOK_ALREADY_LOANED("이미 대출중인 도서입니다."),
    LOAN_ALREADY_RETURNED("이미 반납된 도서입니다. "),
    LOAN_NOT_FOUND("대출내역을 찾을 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

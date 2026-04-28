package com.ch.libraryflow.loan.dto;

public record BookLoanRequest (
        Long memberId,
        Long bookId
) {
}

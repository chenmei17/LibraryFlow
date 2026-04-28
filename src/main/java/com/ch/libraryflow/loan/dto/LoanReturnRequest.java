package com.ch.libraryflow.loan.dto;

public record LoanReturnRequest (
        Long memberId,
        Long bookId
) {
}

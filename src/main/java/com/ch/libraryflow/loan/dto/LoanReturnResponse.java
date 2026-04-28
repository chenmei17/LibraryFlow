package com.ch.libraryflow.loan.dto;

public record LoanReturnResponse(
        Long memberId,
        Long bookId
) {
}

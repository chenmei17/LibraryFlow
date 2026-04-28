package com.ch.libraryflow.loan.dto;

import com.ch.libraryflow.loan.domain.Loan;

import java.time.LocalDateTime;

public record ActiveLoanResponse(
        Long loanId,
        Long memberId,
        Long bookId,
        String bookName,
        LocalDateTime loanedAt
) {
    public static ActiveLoanResponse from(Loan loan) {
        return new ActiveLoanResponse(
                loan.getLoanId(),
                loan.getMember().getMemberId(),
                loan.getBook().getBookId(),
                loan.getBook().getBookName(),
                loan.getLoanedAt()
        );
    }
}
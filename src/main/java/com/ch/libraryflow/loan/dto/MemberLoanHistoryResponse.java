package com.ch.libraryflow.loan.dto;

import com.ch.libraryflow.loan.domain.Loan;

import java.time.LocalDateTime;

public record MemberLoanHistoryResponse (
        Long loanId,
        Long bookId,
        String bookName,
        String loanStatus,
        LocalDateTime loanedAt,
        LocalDateTime returnedAt
) {
    public static MemberLoanHistoryResponse from(Loan loan) {
        return new MemberLoanHistoryResponse(
                loan.getLoanId(),
                loan.getBook().getBookId(),
                loan.getBook().getBookName(),
                loan.getLoanStatus().name(),
                loan.getLoanedAt(),
                loan.getReturnedAt()
        );
    }
}

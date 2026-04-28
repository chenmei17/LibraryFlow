package com.ch.libraryflow.loan.dto;

import com.ch.libraryflow.loan.domain.Loan;

public record LoanReturnResponse(
        Long loanId,
        String loanStatus
) {
    public static LoanReturnResponse from(Loan loan) {
        return new LoanReturnResponse(
                loan.getLoanId(),
                loan.getLoanStatus().name()
        );
    }
}

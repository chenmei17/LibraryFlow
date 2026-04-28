package com.ch.libraryflow.loan.dto;

import java.util.List;

public record MemberLoanListResponse(
        Long memberId,
        List<MemberLoanHistoryResponse> loans
) {
}

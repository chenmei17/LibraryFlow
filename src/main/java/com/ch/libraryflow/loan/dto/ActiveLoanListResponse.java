package com.ch.libraryflow.loan.dto;

import java.util.List;

public record ActiveLoanListResponse (
        List<ActiveLoanResponse> loans
) {
}

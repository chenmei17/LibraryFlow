package com.ch.libraryflow.loan.controller;

import com.ch.libraryflow.loan.dto.*;
import com.ch.libraryflow.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<BookLoanResponse> loan(@RequestBody BookLoanRequest bookLoanRequest) {
        BookLoanResponse response = loanService.bookLoan(bookLoanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<LoanReturnResponse> returnBook(@PathVariable Long loanId) {
        LoanReturnResponse response = loanService.returnLoan(loanId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberLoanListResponse> getMemberLoanHistory(@PathVariable Long memberId) {
        MemberLoanListResponse response = loanService.getMemberLoanHistory(memberId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active")
    public ResponseEntity<ActiveLoanListResponse> getActiveLoans() {
        ActiveLoanListResponse response = loanService.getActiveLoanList();
        return ResponseEntity.ok(response);
    }

}

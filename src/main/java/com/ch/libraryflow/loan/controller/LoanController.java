package com.ch.libraryflow.loan.controller;

import com.ch.libraryflow.loan.dto.*;
import com.ch.libraryflow.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    // TODO: 도서대출v , 도서 반납v, 회원별 대출 이력 조회, 현재 대출중 목록 조회\

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

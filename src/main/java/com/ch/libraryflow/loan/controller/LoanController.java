package com.ch.libraryflow.loan.controller;

import com.ch.libraryflow.loan.dto.BookLoanRequest;
import com.ch.libraryflow.loan.dto.BookLoanResponse;
import com.ch.libraryflow.loan.service.LoanService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;

@Controller
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    // TODO: 도서대출, 도서 반납, 회원별 대출 이력 조회, 현재 대출중 목록 조회\

    private final LoanService loanService;

    @PostMapping
    public HttpResponse<BookLoanResponse> loan(@RequestBody BookLoanRequest bookLoanRequest) {

        BookLoanResponse response = loanService.bookLoan(bookLoanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

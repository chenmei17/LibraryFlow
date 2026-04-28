package com.ch.libraryflow.loan.service;

import com.ch.libraryflow.book.domain.Book;
import com.ch.libraryflow.book.repository.BookRepository;
import com.ch.libraryflow.common.exception.BookNotFoundException;
import com.ch.libraryflow.common.exception.LoanNotFoundException;
import com.ch.libraryflow.common.exception.MemberNotFoundException;
import com.ch.libraryflow.loan.domain.Loan;
import com.ch.libraryflow.loan.domain.LoanStatus;
import com.ch.libraryflow.loan.dto.*;
import com.ch.libraryflow.loan.repository.LoanRepository;
import com.ch.libraryflow.member.domain.Member;
import com.ch.libraryflow.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BookLoanResponse bookLoan(BookLoanRequest bookLoanRequest) {

        Member member = memberRepository.findById(bookLoanRequest.memberId())
                .orElseThrow(()-> new MemberNotFoundException());

        Book book = bookRepository.findById(bookLoanRequest.bookId())
                .orElseThrow(()-> new BookNotFoundException());

        book.loanBook();

        Loan loan = Loan.create(member, book);
        Loan savedLoan = loanRepository.save(loan);

        return BookLoanResponse.from(savedLoan);
    }

    @Transactional
    public LoanReturnResponse returnLoan(Long loanId) {

        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new LoanNotFoundException());
        loan.returnLoan();
        loan.getBook().returnBook();

        return LoanReturnResponse.from(loan);
    }

    @Transactional(readOnly = true)
    public MemberLoanListResponse getMemberLoanHistory(Long memberId) {
        memberRepository.findById(memberId).orElseThrow(()-> new MemberNotFoundException());

        List<Loan> loans = loanRepository.findByMemberMemberId(memberId);

        List<MemberLoanHistoryResponse> response = loans.stream()
                .map(MemberLoanHistoryResponse::from)
                .toList();
        return new MemberLoanListResponse(memberId, response);
    }

    @Transactional(readOnly = true)
    public ActiveLoanListResponse getActiveLoanList() {
        List<ActiveLoanResponse> loans = loanRepository.findByLoanStatus(LoanStatus.LOANED).stream()
                .map(ActiveLoanResponse::from)
                .toList();

        return new ActiveLoanListResponse(loans);
    }
}

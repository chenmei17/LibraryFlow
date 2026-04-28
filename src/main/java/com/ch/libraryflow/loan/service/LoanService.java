package com.ch.libraryflow.loan.service;

import com.ch.libraryflow.book.domain.Book;
import com.ch.libraryflow.book.repository.BookRepository;
import com.ch.libraryflow.common.exception.BookNotFoundException;
import com.ch.libraryflow.common.exception.MemberNotFoundException;
import com.ch.libraryflow.loan.domain.Loan;
import com.ch.libraryflow.loan.dto.BookLoanRequest;
import com.ch.libraryflow.loan.dto.BookLoanResponse;
import com.ch.libraryflow.loan.repository.LoanRepository;
import com.ch.libraryflow.member.domain.Member;
import com.ch.libraryflow.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

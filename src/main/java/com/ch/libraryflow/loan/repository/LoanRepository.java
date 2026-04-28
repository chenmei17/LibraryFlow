package com.ch.libraryflow.loan.repository;

import com.ch.libraryflow.loan.domain.Loan;
import com.ch.libraryflow.loan.domain.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberMemberId(Long memberId);
    List<Loan> findByLoanStatus(LoanStatus loanStatus);
}

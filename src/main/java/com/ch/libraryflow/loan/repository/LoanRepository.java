package com.ch.libraryflow.loan.repository;

import com.ch.libraryflow.loan.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}

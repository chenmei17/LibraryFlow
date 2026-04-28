package com.ch.libraryflow.loan.domain;

import com.ch.libraryflow.book.domain.Book;
import com.ch.libraryflow.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name="loans")
@Getter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDateTime loanedAt;

    protected Loan() {
    }

    private Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.loanedAt = LocalDateTime.now();
    }

    public static Loan create(Member member, Book book) {
        return new Loan(member, book);
    }
}

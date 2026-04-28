package com.ch.libraryflow.book.domain;

import com.ch.libraryflow.common.exception.BookAlreadyLoanedException;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus bookStatus;

    protected Book() {}

    private Book(String bookName, String author, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
        this.bookStatus = BookStatus.AVAILABLE;
    }
    public static Book create(String bookName, String author, String isbn) {
        return new Book(bookName, author, isbn);
    }

    public void loanBook() {
        if (bookStatus == BookStatus.LOANED) {
            throw new BookAlreadyLoanedException();
        }
        this.bookStatus = BookStatus.LOANED;
    }
    public void returnBook() {
        if (bookStatus == BookStatus.AVAILABLE) {
            throw new BookAlreadyLoanedException();
        }
        this.bookStatus = BookStatus.AVAILABLE;
    }
}

package com.ch.libraryflow.book.service;

import com.ch.libraryflow.book.domain.Book;
import com.ch.libraryflow.book.dto.BookCreateRequest;
import com.ch.libraryflow.book.dto.BookListResponse;
import com.ch.libraryflow.book.dto.BookResponse;
import com.ch.libraryflow.book.repository.BookRepository;
import com.ch.libraryflow.common.exception.BookNotFoundException;
import com.ch.libraryflow.common.exception.DuplicateIsbnException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponse registerBook(BookCreateRequest request) {
        validateDuplicateIsbn(request.isbn());

        Book book = Book.create(
                request.bookName(),
                request.author(),
                request.isbn()
        );
        Book savedBook = bookRepository.save(book);
        return toBookResponse(savedBook);
    }

    public BookResponse getBookById(long bookId) {
        Book findBook = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        return toBookResponse(findBook);
    }

    public BookListResponse getAllBookList() {
        List<BookResponse> books = bookRepository.findAll().stream()
                .map(this::toBookResponse)
                .toList();
        return new BookListResponse(books);
    }

    private void validateDuplicateIsbn(String isbn) {
        if(bookRepository.existsByIsbn(isbn)){
            throw new DuplicateIsbnException();
        }
    }

    private BookResponse toBookResponse(Book book) {
        return new BookResponse(
                book.getBookId(),
                book.getBookName(),
                book.getAuthor(),
                book.getIsbn(),
                book.getBookStatus()
        );
    }

}

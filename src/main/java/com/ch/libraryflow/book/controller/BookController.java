package com.ch.libraryflow.book.controller;

import com.ch.libraryflow.book.dto.*;
import com.ch.libraryflow.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> registerBook(@RequestBody BookCreateRequest request){
        BookResponse response = bookService.registerBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long bookId){
        BookResponse response = bookService.getBookById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<BookListResponse> getBookList(){
        BookListResponse response = bookService.getAllBookList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

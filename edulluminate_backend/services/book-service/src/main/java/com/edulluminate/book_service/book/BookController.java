package com.edulluminate.book_service.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book-service/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<BookSummaryResponse> findById(
            @PathVariable("book-id") Integer bookId
    ) {
        return ResponseEntity.ok(bookService.findByIdSummary(bookId));
    }

    @GetMapping("/{book-id}/chapter")
    public ResponseEntity<BookWithChaptersResponse> findByIdWithChapters(
            @PathVariable("book-id") Integer bookId
    ) {
        return ResponseEntity.ok(bookService.findByIdWithChapters(bookId));
    }
}

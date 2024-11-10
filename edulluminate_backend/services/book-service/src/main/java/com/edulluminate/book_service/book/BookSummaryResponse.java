package com.edulluminate.book_service.book;

import com.edulluminate.book_service.author.AuthorSummary;

import java.util.List;

public record BookSummaryResponse(
    Integer id,
    String name,
    String isbn,
    String imageUrl,
    List<AuthorSummary> authors
) {
}

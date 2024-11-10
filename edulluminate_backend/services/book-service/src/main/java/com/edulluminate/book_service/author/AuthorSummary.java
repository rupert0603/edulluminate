package com.edulluminate.book_service.author;

public record AuthorSummary(
        Integer id,
        String firstName,
        String lastName,
        String suffix
) {
}

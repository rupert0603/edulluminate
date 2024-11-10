package com.edulluminate.book_service.book;

import com.edulluminate.book_service.author.AuthorSummary;
import com.edulluminate.book_service.chapter.ChapterSummary;

import java.util.List;

public record BookWithChaptersResponse(
        Integer id,
        String name,
        String isbn,
        String imageUrl,
        List<AuthorSummary> authors,
        List<ChapterSummary> chapters
) {
}

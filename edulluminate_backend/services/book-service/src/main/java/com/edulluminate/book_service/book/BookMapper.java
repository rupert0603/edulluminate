package com.edulluminate.book_service.book;

import com.edulluminate.book_service.author.AuthorSummary;
import com.edulluminate.book_service.chapter.ChapterSummary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

    public BookSummaryResponse toBookSummary(Book book) {
        return new BookSummaryResponse(
            book.getId(),
                book.getName(),
                book.getIsbn(),
                book.getImageUrl(),
                book.getAuthors().stream().map((author) -> {
                    return new AuthorSummary(
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                            author.getSuffix()
                    );
                }).toList()
        );
    }

    public BookWithChaptersResponse toBookWithChapters(Book book, List<ChapterSummary> chapters) {
        return new BookWithChaptersResponse(
                book.getId(),
                book.getName(),
                book.getIsbn(),
                book.getImageUrl(),
                book.getAuthors().stream().map((author) -> {
                    return new AuthorSummary(
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                            author.getSuffix()
                    );
                }).toList(),
                chapters
        );
    }
}

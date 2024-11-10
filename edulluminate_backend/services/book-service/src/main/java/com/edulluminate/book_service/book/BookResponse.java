package com.edulluminate.book_service.book;

import com.edulluminate.book_service.chapter.ChapterSummary;

import java.util.List;

public record BookResponse (
        Book book,
        List<ChapterSummary> chapters
){
}

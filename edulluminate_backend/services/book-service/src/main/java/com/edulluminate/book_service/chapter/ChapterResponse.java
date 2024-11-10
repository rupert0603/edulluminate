package com.edulluminate.book_service.chapter;

public record ChapterResponse(
        Integer id,
        Integer chapterOrder,
        String title,
        String content
) {
}

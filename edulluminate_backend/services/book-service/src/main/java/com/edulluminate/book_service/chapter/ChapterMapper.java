package com.edulluminate.book_service.chapter;

import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {
    public ChapterResponse toChapterResponse(Chapter chapter) {
        return new ChapterResponse(
                chapter.getId(),
                chapter.getChapterOrder(),
                chapter.getTitle(),
                chapter.getContent()
        );
    }
}

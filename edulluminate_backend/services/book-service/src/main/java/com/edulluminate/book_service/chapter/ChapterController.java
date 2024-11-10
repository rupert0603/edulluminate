package com.edulluminate.book_service.chapter;

import com.edulluminate.book_service.question.QuestionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-service/chapter")
public class ChapterController {
    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/{chapter-id}")
    public ResponseEntity<ChapterResponse> findById (
            @PathVariable("chapter-id") Integer chapterId
    ) {
        return ResponseEntity.ok(chapterService.findById(chapterId));
    }

    @GetMapping("/{chapter-id}/question")
    public ResponseEntity<List<QuestionResponse>> getQuestions(
            @PathVariable("chapter-id") Integer chapterId,
            @RequestParam(name = "page") Integer page

    ) {
        return ResponseEntity.ok(chapterService.getQuestions(chapterId, page));
    }
}

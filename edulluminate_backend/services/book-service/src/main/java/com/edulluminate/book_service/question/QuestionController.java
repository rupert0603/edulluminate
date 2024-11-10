package com.edulluminate.book_service.question;

import com.edulluminate.book_service.answer.AnswerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-service/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{question-id}/answer")
    public ResponseEntity<List<AnswerResponse>> getAnswers(
            @PathVariable("question-id") Integer questionId
    ){
        return ResponseEntity.ok(questionService.getAnswers(questionId));
    }
}

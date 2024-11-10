package com.edulluminate.book_service.question;

import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public QuestionResponse toQuestionResponse(Question question) {
        return new QuestionResponse(
                question.getId(),
                question.getQuestionOrder(),
                question.getQuestion()
        );
    }
}

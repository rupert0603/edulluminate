package com.edulluminate.book_service.answer;

import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public AnswerResponse toAnswerResponse(Answer answer) {
        return new AnswerResponse(
                answer.getId(),
                answer.getAnswer(),
                answer.getCreatedAt()
                );
    }
}

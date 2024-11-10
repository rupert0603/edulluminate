package com.edulluminate.book_service.question;

public record QuestionResponse(
        Integer id,
        Integer questionOrder,
        String question
) {
}

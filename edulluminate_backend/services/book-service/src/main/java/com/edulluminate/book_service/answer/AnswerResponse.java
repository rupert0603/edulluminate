package com.edulluminate.book_service.answer;

import java.time.LocalDateTime;

public record AnswerResponse(
        Integer id,
        String answer,
        LocalDateTime createdAt
) {
}

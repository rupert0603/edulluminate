package com.edulluminate.book_service.question;

import com.edulluminate.book_service.answer.AnswerMapper;
import com.edulluminate.book_service.answer.AnswerRepository;
import com.edulluminate.book_service.answer.AnswerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public QuestionService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    public List<AnswerResponse> getAnswers(Integer questionId) {
        return answerRepository.findByQuestionId(questionId).stream()
                .map(answerMapper::toAnswerResponse)
                .toList();
    }
}

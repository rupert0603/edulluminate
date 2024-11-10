package com.edulluminate.book_service.chapter;

import com.edulluminate.book_service.question.QuestionMapper;
import com.edulluminate.book_service.question.QuestionRepository;
import com.edulluminate.book_service.question.QuestionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final QuestionRepository questionRepository;
    private final ChapterMapper chapterMapper;
    private final QuestionMapper questionMapper;

    public ChapterService(ChapterRepository chapterRepository, QuestionRepository questionRepository, ChapterMapper chapterMapper, QuestionMapper questionMapper) {
        this.chapterRepository = chapterRepository;
        this.questionRepository = questionRepository;
        this.chapterMapper = chapterMapper;
        this.questionMapper = questionMapper;
    }

    public ChapterResponse findById(Integer chapterId) {
        return chapterRepository.findById(chapterId)
                .map(chapterMapper::toChapterResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No chapter found with id: %d", chapterId)));
    }

    public List<QuestionResponse> getQuestions(Integer chapterId, Integer page) {
        Pageable sortedByQuestionOrder = PageRequest.of(page, 10, Sort.by("questionOrder").ascending());

        return questionRepository.findByChapterId(chapterId, sortedByQuestionOrder)
                .stream()
                .map(questionMapper::toQuestionResponse)
                .toList();
    }
}

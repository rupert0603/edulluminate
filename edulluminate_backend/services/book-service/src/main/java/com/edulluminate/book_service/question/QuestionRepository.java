package com.edulluminate.book_service.question;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByChapterId(Integer chapterId, Pageable pageable);

}

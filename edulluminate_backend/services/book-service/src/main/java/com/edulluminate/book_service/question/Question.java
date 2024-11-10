package com.edulluminate.book_service.question;

import com.edulluminate.book_service.answer.Answer;
import com.edulluminate.book_service.chapter.Chapter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_order")
    private Integer questionOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    public Question() {
    }

    public Question(Integer id, Integer questionOrder, Chapter chapter, String question, List<Answer> answers) {
        this.id = id;
        this.questionOrder = questionOrder;
        this.chapter = chapter;
        this.question = question;
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionOrder=" + questionOrder +
//                ", chapter=" + chapter +
                ", question='" + question + '\'' +
//                ", answers=" + answers +
                '}';
    }
}

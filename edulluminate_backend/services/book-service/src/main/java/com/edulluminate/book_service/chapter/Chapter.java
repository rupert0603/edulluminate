package com.edulluminate.book_service.chapter;

import com.edulluminate.book_service.book.Book;
import com.edulluminate.book_service.question.Question;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "chapter_order")
    private Integer chapterOrder;

    private String title;

    @OneToMany(
            fetch = FetchType.LAZY,
//            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "chapter"
    )
//    @JoinColumn(name = "chapter_id")
    private List<Question> questions;

    public Chapter() {
    }

    public Chapter(Integer id, Book book, String content, Integer chapterOrder, String title,
                   List<Question> questions
    ) {
        this.id = id;
        this.book = book;
        this.content = content;
        this.chapterOrder = chapterOrder;
        this.title = title;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", book=" + book +
                ", content='" + content + '\'' +
                ", chapterOrder=" + chapterOrder +
                ", title='" + title + '\'' +
//                ", questions=" + questions +
                '}';
    }
}

package com.edulluminate.book_service.book;

import com.edulluminate.book_service.author.Author;
import com.edulluminate.book_service.chapter.Chapter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String isbn;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(
        fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.REFRESH}
    )
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "book"
    )
//    @JoinColumn(name = "book_id")
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(Integer id, String name, String isbn, String imageUrl, List<Author> authors, List<Chapter> chapters) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.authors = authors;
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
//                ", authors=" + authors +
//                ", chapters=" + chapters +
                '}';
    }
}

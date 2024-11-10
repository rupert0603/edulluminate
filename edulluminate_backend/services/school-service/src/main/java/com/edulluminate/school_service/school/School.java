package com.edulluminate.school_service.school;

import com.edulluminate.school_service.country.Country;
import com.edulluminate.school_service.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "jsonb")
    private String document;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(
            fetch = FetchType.LAZY,
//            mappedBy = "school_id",
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    private List<Review> reviews;

    public School() {
    }

    public School(Integer id, String name, String document, Country country, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.country = country;
        this.reviews = reviews;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", country=" + country +
                ", reviews=" + reviews +
                '}';
    }
}

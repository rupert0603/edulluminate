package com.edulluminate.school_service.review;

import com.edulluminate.school_service.school.School;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;
//    @Column(name = "school_id")
//    private Integer schoolId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "academics_rating")
    private Integer academicsRating;

    @Column(name = "food_rating")
    private Integer foodRating;

    @Column(name = "clubs_rating")
    private Integer clubsRating;

    @Column(name = "location_rating")
    private Integer locationRating;

    @Column(name = "student_life_rating")
    private Integer studentLifeRating;

    @Column(name = "teachers_rating")
    private Integer teachersRating;

    @Column(name = "facilities_rating")
    private Integer facilitiesRating;

    @Column(name = "sports_rating")
    private Integer sportsRating;

    @Column(name = "peer_quality_rating")
    private Integer peerQualityRating;

    @Column(name = "staffs_rating")
    private Integer staffsRating;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    public Review() {
    }

    public Review(
//            Integer id,
                  String review,
//                  School school,
                  String userId, Integer academicsRating, Integer foodRating, Integer clubsRating, Integer locationRating, Integer studentLifeRating, Integer teachersRating, Integer facilitiesRating, Integer sportsRating, Integer peerQualityRating, Integer staffsRating) {
//        this.id = id;
        this.review = review;
//        this.school = school;
        this.userId = userId;
        this.academicsRating = academicsRating;
        this.foodRating = foodRating;
        this.clubsRating = clubsRating;
        this.locationRating = locationRating;
        this.studentLifeRating = studentLifeRating;
        this.teachersRating = teachersRating;
        this.facilitiesRating = facilitiesRating;
        this.sportsRating = sportsRating;
        this.peerQualityRating = peerQualityRating;
        this.staffsRating = staffsRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAcademicsRating() {
        return academicsRating;
    }

    public void setAcademicsRating(Integer academicsRating) {
        this.academicsRating = academicsRating;
    }

    public Integer getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Integer foodRating) {
        this.foodRating = foodRating;
    }

    public Integer getClubsRating() {
        return clubsRating;
    }

    public void setClubsRating(Integer clubsRating) {
        this.clubsRating = clubsRating;
    }

    public Integer getLocationRating() {
        return locationRating;
    }

    public void setLocationRating(Integer locationRating) {
        this.locationRating = locationRating;
    }

    public Integer getStudentLifeRating() {
        return studentLifeRating;
    }

    public void setStudentLifeRating(Integer studentLifeRating) {
        this.studentLifeRating = studentLifeRating;
    }

    public Integer getTeachersRating() {
        return teachersRating;
    }

    public void setTeachersRating(Integer teachersRating) {
        this.teachersRating = teachersRating;
    }

    public Integer getFacilitiesRating() {
        return facilitiesRating;
    }

    public void setFacilitiesRating(Integer facilitiesRating) {
        this.facilitiesRating = facilitiesRating;
    }

    public Integer getSportsRating() {
        return sportsRating;
    }

    public void setSportsRating(Integer sportsRating) {
        this.sportsRating = sportsRating;
    }

    public Integer getPeerQualityRating() {
        return peerQualityRating;
    }

    public void setPeerQualityRating(Integer peerQualityRating) {
        this.peerQualityRating = peerQualityRating;
    }

    public Integer getStaffsRating() {
        return staffsRating;
    }

    public void setStaffsRating(Integer staffsRating) {
        this.staffsRating = staffsRating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
//                ", school=" + school +
                ", userId='" + userId + '\'' +
                ", academicsRating=" + academicsRating +
                ", foodRating=" + foodRating +
                ", clubsRating=" + clubsRating +
                ", locationRating=" + locationRating +
                ", studentLifeRating=" + studentLifeRating +
                ", teachersRating=" + teachersRating +
                ", facilitiesRating=" + facilitiesRating +
                ", sportsRating=" + sportsRating +
                ", peerQualityRating=" + peerQualityRating +
                ", staffsRating=" + staffsRating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

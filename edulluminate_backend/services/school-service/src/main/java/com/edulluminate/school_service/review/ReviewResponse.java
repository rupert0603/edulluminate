package com.edulluminate.school_service.review;

import com.edulluminate.school_service.school.School;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record ReviewResponse(
        Integer id,
        String review,
//        School school,
//        String userId,
        Integer academicsRating,
        Integer foodRating,
        Integer clubsRating,
        Integer locationRating,
        Integer studentLifeRating,
        Integer teachersRating,
        Integer facilitiesRating,
        Integer sportsRating,
        Integer peerQualityRating,
        Integer staffsRating,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}

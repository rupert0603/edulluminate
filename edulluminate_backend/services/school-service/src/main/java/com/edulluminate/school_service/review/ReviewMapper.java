package com.edulluminate.school_service.review;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewMapper {
    public Review toReview(ReviewRequest reviewRequest, String userId) {
        return new Review(
                reviewRequest.review(),
                userId,
        reviewRequest.academicsRating(),
        reviewRequest.foodRating(),
        reviewRequest.clubsRating(),
        reviewRequest.locationRating(),
        reviewRequest.studentLifeRating(),
        reviewRequest.teachersRating(),
        reviewRequest.facilitiesRating(),
        reviewRequest.sportsRating(),
        reviewRequest.peerQualityRating(),
        reviewRequest.staffsRating()

        );
    }
    
    public ReviewResponse toReviewResponse(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getReview(),
                review.getAcademicsRating(),
                review.getFoodRating(),
                review.getClubsRating(),
                review.getLocationRating(),
                review.getStudentLifeRating(),
                review.getTeachersRating(),
                review.getFacilitiesRating(),
                review.getSportsRating(),
                review.getPeerQualityRating(),
                review.getStaffsRating(),
                review.getCreatedAt(),
                review.getUpdatedAt()
        );
    }
}

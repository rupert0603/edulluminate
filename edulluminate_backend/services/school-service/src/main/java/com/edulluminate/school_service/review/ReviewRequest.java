package com.edulluminate.school_service.review;

import jakarta.validation.constraints.NotNull;

public record ReviewRequest (
    @NotNull(message = "Review is required")
    String review,
    @NotNull(message = "Review is required")
    Integer schoolId,
    Integer staffsRating,
    Integer peerQualityRating,
    Integer sportsRating,
    Integer facilitiesRating,
    Integer teachersRating,
    Integer studentLifeRating,
    Integer locationRating,
    Integer clubsRating,
    Integer foodRating,
    Integer academicsRating
) {
}

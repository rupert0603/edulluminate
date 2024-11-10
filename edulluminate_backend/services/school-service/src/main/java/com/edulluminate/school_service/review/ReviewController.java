package com.edulluminate.school_service.review;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school-service/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Integer> createReview(
            @RequestBody @Valid ReviewRequest reviewRequest,
            Authentication auth
    ) {

        return ResponseEntity.ok(reviewService.createReview(reviewRequest, auth.getName()));
    }
}

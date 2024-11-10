package com.edulluminate.school_service.review;

import com.edulluminate.school_service.school.School;
import com.edulluminate.school_service.school.SchoolRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final SchoolRepository schoolRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, SchoolRepository schoolRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.schoolRepository = schoolRepository;
        this.reviewMapper = reviewMapper;
    }

    public Integer createReview(@Valid ReviewRequest request, String userId) {
        if(userId == null){
            throw new IllegalArgumentException("Request invalid");
        }

        School school = schoolRepository.getReferenceById(request.schoolId());

        Review review = reviewMapper.toReview(request, userId);
        review.setSchool(school);

        Review reviewResult = reviewRepository.save(review);
//        System.out.println(reviewResult);
        return reviewResult.getId();
    }
}

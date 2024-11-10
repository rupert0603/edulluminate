package com.edulluminate.school_service.school;

import com.edulluminate.school_service.review.Review;
import com.edulluminate.school_service.review.ReviewMapper;
import com.edulluminate.school_service.review.ReviewRepository;
import com.edulluminate.school_service.review.ReviewResponse;
import com.edulluminate.school_service.school_detail.SchoolDetail;
import com.edulluminate.school_service.school_detail.SchoolDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolDetailRepository schoolDetailRepository;
    private final SchoolMapper schoolMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolDetailRepository schoolDetailRepository, SchoolMapper schoolMapper, ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolDetailRepository = schoolDetailRepository;
        this.schoolMapper = schoolMapper;
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    //    @Transactional
    public SchoolDetail findById(Integer schoolId) {
//        Optional<School> result = schoolRepository.findById(schoolId);
//        if(result.isPresent()) {
//            School school = result.get();
//            List<Review> reviews = school.getReviews();
//             System.out.println(reviews);
//        }

//        return schoolRepository.findById(schoolId)
//                .map(schoolMapper::toSchoolResponse)
//                .orElseThrow(
//                        () -> new EntityNotFoundException(String.format("No school found with id: %d", schoolId))
//                );

        Optional<SchoolDetail> schoolDetail = schoolDetailRepository.findById(schoolId);
        if(schoolDetail.isPresent()){
            return schoolDetail.get();
        } else {
            throw new EntityNotFoundException(String.format("No school found with id: %d", schoolId));
        }

    }

    public List<SchoolDetail> findSchools(String searchString, Integer lastItemId) {
        return schoolDetailRepository.searchByText(searchString, lastItemId);
    }
//    public List<SchoolResponse> findAll() {
//
//    }
    public List<ReviewResponse> getReviewsBySchoolId(Integer schoolId) {
        return reviewRepository.findBySchoolIdOrderByIdDesc(schoolId)
                .stream().map(reviewMapper::toReviewResponse)
                .toList();
    }
}

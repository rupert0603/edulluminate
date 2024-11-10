package com.edulluminate.school_service.school;

import com.edulluminate.school_service.review.Review;
import com.edulluminate.school_service.review.ReviewResponse;
import com.edulluminate.school_service.school_detail.SchoolDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school-service/school")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/{school-id}")
    public ResponseEntity<SchoolDetail> findById (
        @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(schoolService.findById(schoolId));
    }

    @GetMapping
    public ResponseEntity<List<SchoolDetail>>  findSchools (
            @RequestParam(name = "query") String query,
            @RequestParam(name = "lastItemId") Integer lastItemId
    ) {
        return ResponseEntity.ok(schoolService.findSchools(query, lastItemId));
    }

    @GetMapping("/{school-id}/review")
    public ResponseEntity<List<ReviewResponse>> getReviews(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(schoolService.getReviewsBySchoolId(schoolId));
    }
}

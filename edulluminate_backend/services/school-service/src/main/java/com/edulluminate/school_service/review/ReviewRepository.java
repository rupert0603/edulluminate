package com.edulluminate.school_service.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findBySchoolIdOrderByIdDesc(Integer schoolId);
}

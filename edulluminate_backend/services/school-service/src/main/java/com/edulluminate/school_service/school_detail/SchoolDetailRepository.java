package com.edulluminate.school_service.school_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolDetailRepository extends JpaRepository<SchoolDetail, Integer> {

    @Query(value = """
            select * from school_detail where
            to_tsvector('english', name || ' ' || taxonomy || ' ' || municipality || ' ' || country || ' ' || alpha_2 || ' ' || alpha_3 )
            @@ websearch_to_tsquery(:search)
            AND id > :lastItemId
            order by id ASC
            limit 10;
           """, nativeQuery = true)
    List<SchoolDetail> searchByText(@Param("search") String search, @Param("lastItemId") Integer lastItemId);
}

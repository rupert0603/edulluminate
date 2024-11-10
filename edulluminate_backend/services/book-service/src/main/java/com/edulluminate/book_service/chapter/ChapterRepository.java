package com.edulluminate.book_service.chapter;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

//    @Query("SELECT c.id, c.chapterOrder, c.title FROM Chapter c where c.book.id = ?1")
//    List<ChapterSummary> findAllChapterTitles(Integer bookId);

    @Query(value = "SELECT id, chapter_order, title FROM chapter where book_id = ?1 ORDER BY chapter_order ASC", nativeQuery = true)
    List<ChapterSummary> findAllChapterTitles(Integer bookId);
}

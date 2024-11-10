package com.edulluminate.book_service.book;

import com.edulluminate.book_service.chapter.Chapter;
import com.edulluminate.book_service.chapter.ChapterRepository;
import com.edulluminate.book_service.chapter.ChapterSummary;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ChapterRepository chapterRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, ChapterRepository chapterRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.chapterRepository = chapterRepository;
        this.bookMapper = bookMapper;
    }

    public BookSummaryResponse findByIdSummary(Integer bookId) {
//        return bookRepository.findById(bookId)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("No book found with id: %d", bookId)));

        return bookRepository.findById(bookId)
                .map(bookMapper::toBookSummary)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No book found with id: %d", bookId)));

//        Optional<Book> test = bookRepository.findById(bookId);
//        Book test1 = test.get();
//        System.out.println(test1.getChapters());
//        return test1;
    }

//    interface TEST {
//        String getTitle();
//    }
    @Transactional
    public BookWithChaptersResponse findByIdWithChapters(Integer bookId) {

        Optional<Book> result = bookRepository.findById(bookId);
        List<ChapterSummary> chapters = null;
        if(result.isPresent()) {
            chapters = chapterRepository.findAllChapterTitles(bookId);
//            System.out.println(chapters);
        } else {
            throw new EntityNotFoundException(String.format("No book found with id: %d", bookId));
        }

        return bookMapper.toBookWithChapters(
                result.get(),
                chapters
        );
//        return new BookResponse(
//                result.get(),
//                chapters
//        );

//        Optional<Book> result = bookRepository.findById(bookId);

//        return bookRepository.findById(bookId)
//            .map((book) -> {
//                book.getChapters();
//                return book;
//            }).orElseThrow(() -> new EntityNotFoundException(String.format("No book found with id: %d", bookId)));

//        if(result.isPresent()){
//
//        }
    }
}

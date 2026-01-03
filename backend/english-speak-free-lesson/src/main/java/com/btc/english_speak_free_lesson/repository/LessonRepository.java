package com.btc.english_speak_free_lesson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_lesson.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findByCode(String code);

    List<Lesson> findByActiveTrueOrderByOrderIndexAsc();
    
    Page<Lesson> findByActiveTrue(Pageable pageable);
    
    Page<Lesson> findByActiveTrueAndLevel(
            String level,
            Pageable pageable
    );

}

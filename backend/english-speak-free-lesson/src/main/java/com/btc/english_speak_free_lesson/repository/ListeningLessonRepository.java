package com.btc.english_speak_free_lesson.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_lesson.model.ListeningLesson;

@Repository
public interface ListeningLessonRepository extends JpaRepository<ListeningLesson, Long> {

	Page<ListeningLesson> findByActiveTrue(Pageable pageable);
}

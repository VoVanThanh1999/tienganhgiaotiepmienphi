package com.btc.english_speak_free_lesson.repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.btc.english_speak_free_lesson.model.GrammarLesson;

public interface GrammarLessonRepository extends JpaRepository<GrammarLesson, Long> {

	Optional<GrammarLesson> findByCode(String code);

	Page<GrammarLesson> findByLevel(String level, Pageable pageable);
}

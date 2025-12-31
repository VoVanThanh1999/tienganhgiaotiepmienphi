package com.btc.english_speak_free_lesson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_lesson.model.LessonContent;

@Repository
public interface LessonContentRepository extends JpaRepository<LessonContent, Long> {

	Optional<LessonContent> findByLessonId(Long lessonId);

	List<LessonContent> findByLessonIdIn(List<Long> lessonIds);
}

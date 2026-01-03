package com.btc.english_speak_free_lesson.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_lesson.model.ListeningQuestion;

@Repository
public interface ListeningQuestionRepository extends JpaRepository<ListeningQuestion, Long> {

	List<ListeningQuestion> findByLessonId(Long lessonId);
	
    Page<ListeningQuestion> findByLessonId(
            Long lessonId,
            Pageable pageable
    );
}

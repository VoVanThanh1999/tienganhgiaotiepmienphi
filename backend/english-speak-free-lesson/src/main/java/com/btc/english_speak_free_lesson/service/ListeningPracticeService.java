package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.btc.english_speak_free_lesson.dto.ListeningLessonResponse;
import com.btc.english_speak_free_lesson.dto.ListeningQuestionResponse;
import com.btc.english_speak_free_lesson.model.ListeningLesson;
import com.btc.english_speak_free_lesson.repository.ListeningLessonRepository;
import com.btc.english_speak_free_lesson.repository.ListeningQuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListeningPracticeService {

	private final ListeningLessonRepository lessonRepo;
	private final ListeningQuestionRepository questionRepo;

	/* ===== LOAD LESSON ===== */
	public ListeningLessonResponse getLesson(Long lessonId) {

		ListeningLesson lesson = lessonRepo.findById(lessonId)
				.orElseThrow(() -> new RuntimeException("Lesson not found"));

		List<ListeningQuestionResponse> questions = questionRepo.findByLessonId(lessonId).stream()
				.map(q -> new ListeningQuestionResponse(q.getId(), q.getLessonId(), q.getQuestion(), q.getOptions(), q.getCorrectIndex())).toList();

		return new ListeningLessonResponse(lesson.getId(), lesson.getTitle(), lesson.getTopic(), lesson.getLevel(),
				lesson.getDuration(), lesson.getAudioUrl(), lesson.getSlowAudioUrl(), lesson.getTranscript(),
				questions);
	}
 
}

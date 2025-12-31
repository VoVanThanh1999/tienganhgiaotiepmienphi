package com.btc.english_speak_free_lesson.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.btc.english_speak_free_lesson.common.PromtCommon;
import com.btc.english_speak_free_lesson.dto.PracticeSubmitResponse;
import com.btc.english_speak_free_lesson.model.LessonContent;
import com.btc.english_speak_free_lesson.model.LessonPracticeSubmission;
import com.btc.english_speak_free_lesson.model.data.PracticeType;
import com.btc.english_speak_free_lesson.repository.LessonContentRepository;
import com.btc.english_speak_free_lesson.repository.LessonPracticeSubmissionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonPracticeService {
	
	private final LessonContentRepository contentRepo;
	private final LessonPracticeSubmissionRepository submissionRepo;
	private final AIGptService aiGptService;
	
	
	@Transactional
	public PracticeSubmitResponse submitPractice(Long userId, Long lessonId, String userAnswer, PracticeType type) {

		// 1. Load lesson content
		LessonContent content = contentRepo.findByLessonId(lessonId)
				.orElseThrow(() -> new RuntimeException("Lesson content not found"));

		List<String> questions	 = (List<String>) content.getContent().get("grammar_practice");
				
		// 2. Build prompt
		StringBuilder questionsBuilder = new StringBuilder();
		for(String question: questions) {
			questionsBuilder.append(question);
		}
		
		String promt = new String();
		promt += PromtCommon.PROMT_1 + PromtCommon.PROMT_2 + questionsBuilder.toString() + PromtCommon.PROMT_3 + userAnswer;
		
		String feedback = aiGptService.getAnswers(promt);
		
		// 3. Save submission
		LessonPracticeSubmission sub = new LessonPracticeSubmission();
		sub.setUserId(userId);
		sub.setLessonId(lessonId);
		sub.setPracticeType(type);
		sub.setUserAnswer(userAnswer);
		sub.setFeedback(feedback);

		submissionRepo.save(sub);

		return new PracticeSubmitResponse(feedback);
	}
	
}

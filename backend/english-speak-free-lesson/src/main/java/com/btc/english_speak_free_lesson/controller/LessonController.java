package com.btc.english_speak_free_lesson.controller;
 
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.btc.english_speak_free_lesson.dto.LessonCreateRequest;
import com.btc.english_speak_free_lesson.dto.LessonResponse;
import com.btc.english_speak_free_lesson.dto.PracticeSubmitRequest;
import com.btc.english_speak_free_lesson.dto.PracticeSubmitResponse;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.data.PracticeType;
import com.btc.english_speak_free_lesson.service.LessonPracticeService;
import com.btc.english_speak_free_lesson.service.LessonService;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

	private final LessonService lessonService;
	private final LessonPracticeService practiceService;

	@GetMapping
	public PageResponse<LessonResponse> getLessons(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "level", required = false) String level) {
		return lessonService.getPage(page, size, level);
	}

	@GetMapping("/{code}")
	public LessonResponse getLessonDetail(@PathVariable String code) {
		return lessonService.getByCode(code);
	}
	
	@PostMapping
	public LessonResponse createResponse(@RequestBody LessonCreateRequest request) {
		return lessonService.create(request);
	}
	
	@DeleteMapping("/del/{id}")
	public void deleteById(@PathVariable Long id) {
		lessonService.delete(id);
	}
	
	@PostMapping("/{lessonId}/grammar-practice/submit")
	public PracticeSubmitResponse submitGrammarPractice(@PathVariable("lessonId") String lessonId,
			@RequestBody PracticeSubmitRequest request, @RequestHeader("X-User-Id") String userId) {
		return practiceService.submitPractice(Long.valueOf(userId), Long.valueOf(lessonId), request.getAnswer(),
				PracticeType.GRAMMAR);
	}
	
	@PostMapping("/{lessonId}/translation-practice/submit")
	public PracticeSubmitResponse submitTranslationPractice(@PathVariable("lessonId") String lessonId,
			@RequestBody PracticeSubmitRequest request, @RequestHeader("X-User-Id") String userId) {
		return practiceService.submitPractice(Long.valueOf(userId), Long.valueOf(lessonId), request.getAnswer(),
				PracticeType.TRANSLATION);
	}
	
}
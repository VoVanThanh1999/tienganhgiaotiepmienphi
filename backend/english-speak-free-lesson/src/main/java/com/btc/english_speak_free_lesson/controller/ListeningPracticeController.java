package com.btc.english_speak_free_lesson.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btc.english_speak_free_lesson.dto.ListeningLessonResponse;
import com.btc.english_speak_free_lesson.dto.ListeningSubmitRequest;
import com.btc.english_speak_free_lesson.dto.ListeningSubmitResponse;
import com.btc.english_speak_free_lesson.service.ListeningPracticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/listening-pratice")
@RequiredArgsConstructor
public class ListeningPracticeController {
 
	private final ListeningPracticeService service;

	/* ===== LOAD BÀI NGHE ===== */
	@GetMapping("/{lessonId}")
	public ListeningLessonResponse getLesson(@PathVariable(name = "lessonId") Long lessonId) {
		return service.getLesson(lessonId);
	}

	/* ===== SUBMIT ===== */
	@PostMapping("/submit")
	public List<ListeningSubmitResponse> submit(@RequestBody List<ListeningSubmitRequest> request) {
		return service.submit(request);
	}
}

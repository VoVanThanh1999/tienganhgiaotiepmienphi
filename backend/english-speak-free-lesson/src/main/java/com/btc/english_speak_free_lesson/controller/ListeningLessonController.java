package com.btc.english_speak_free_lesson.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btc.english_speak_free_lesson.dto.ListeningLessonResponse;
import com.btc.english_speak_free_lesson.dto.ListeningLessonUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.ListeningLesson;
import com.btc.english_speak_free_lesson.service.ListeningLessonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/listening-lessons")
@RequiredArgsConstructor
public class ListeningLessonController {

	private final ListeningLessonService service;

	@GetMapping
	public PageResponse<ListeningLessonResponse> getPage(@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		return service.getPage(page, size);
	}

	@GetMapping("/{id}")
	public ListeningLessonResponse getDetail(@PathVariable(name = "id") Long id) {
		return service.getDetail(id);
	}

	@PostMapping
	public ListeningLessonResponse create(@RequestBody ListeningLesson request) {
		return service.create(request);
	}

	@PutMapping("/{id}")
	public ListeningLessonResponse update(@PathVariable(name = "id") Long id,
			@RequestBody ListeningLessonUpdateRequest request) {
		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
}

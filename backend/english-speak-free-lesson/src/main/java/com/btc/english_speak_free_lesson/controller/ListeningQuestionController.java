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

import com.btc.english_speak_free_lesson.dto.ListeningQuestionResponse;
import com.btc.english_speak_free_lesson.dto.ListeningQuestionUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.ListeningQuestion;
import com.btc.english_speak_free_lesson.service.ListeningQuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/listening-questions")
@RequiredArgsConstructor
public class ListeningQuestionController {

	private final ListeningQuestionService service;

	@GetMapping
	public PageResponse<ListeningQuestionResponse> getPage(@RequestParam(name ="lessonId") Long lessonId, @RequestParam(name="page") int page,
			@RequestParam(name="size") int size) {
		return service.getPage(lessonId, page, size);
	}

	@GetMapping("/{id}")
	public ListeningQuestionResponse getDetail(@PathVariable(name="id") Long id) {
		return service.getDetail(id);
	}

	@PostMapping
	public ListeningQuestionResponse create(@RequestBody ListeningQuestion request) {
		return service.create(request);
	}

	@PutMapping("/{id}")
	public ListeningQuestionResponse update(@PathVariable(name="id") Long id,
			@RequestBody ListeningQuestionUpdateRequest request) {
		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		service.delete(id);
	}
}

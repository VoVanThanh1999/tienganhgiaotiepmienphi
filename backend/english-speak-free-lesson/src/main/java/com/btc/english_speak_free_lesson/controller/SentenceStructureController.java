package com.btc.english_speak_free_lesson.controller;

import org.springframework.web.bind.annotation.*;

import com.btc.english_speak_free_lesson.dto.SentenceStructureResponse;
import com.btc.english_speak_free_lesson.dto.SentenceStructureUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.SentenceStructure;
import com.btc.english_speak_free_lesson.service.SentenceStructureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/sentence-structures")
@RequiredArgsConstructor
public class SentenceStructureController {

	private final SentenceStructureService service;

	/* ===== LIST ===== */
	@GetMapping
	public PageResponse<SentenceStructureResponse> getPage(@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		return service.getPage(page, size);
	}

	/* ===== DETAIL ===== */
	@GetMapping("/{code}")
	public SentenceStructureResponse getDetail(@PathVariable(name = "code") String code) {
		return service.getDetail(code);
	}

	/* ===== CREATE ===== */
	@PostMapping
	public SentenceStructureResponse create(@RequestBody SentenceStructure request) {
		SentenceStructure saved = service.save(request);
		return service.getDetail(saved.getCode());
	}

	/* ===== UPDATE ===== */
	@PutMapping("/{id}")
	public SentenceStructureResponse update(@PathVariable(name = "id") Long id,
			@RequestBody SentenceStructureUpdateRequest request) {
		return service.update(id, request);
	}

	/* ===== DELETE ===== */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
}

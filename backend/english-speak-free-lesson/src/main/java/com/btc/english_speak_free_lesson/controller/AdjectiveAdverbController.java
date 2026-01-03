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

import com.btc.english_speak_free_lesson.dto.AdjectiveAdverbResponse;
import com.btc.english_speak_free_lesson.dto.AdjectiveAdverbUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.AdjectiveAdverb;
import com.btc.english_speak_free_lesson.service.AdjectiveAdverbService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/adjective-adverbs")
@RequiredArgsConstructor
public class AdjectiveAdverbController {
	
	private final AdjectiveAdverbService service;

	@PostMapping
	public AdjectiveAdverbResponse create(@RequestBody AdjectiveAdverb request) {
		AdjectiveAdverb saved = service.save(request);
		return service.getDetail(saved.getAdjective());
	}
	
	@PutMapping("/{id}")
	public AdjectiveAdverbResponse update(@PathVariable(name="id") Long id, @RequestBody AdjectiveAdverbUpdateRequest request) {
		return service.update(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public PageResponse<AdjectiveAdverbResponse> getPage(@RequestParam(name = "page") int page,
			@RequestParam(name="size") int size) {
		return service.getPage(page, size);
	}

	@GetMapping("/{adjective}")
	public AdjectiveAdverbResponse getDetail(@PathVariable(name="adjective") String adjective) {
		return service.getDetail(adjective);
	}
}

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

import com.btc.english_speak_free_lesson.dto.GrammarResponse;
import com.btc.english_speak_free_lesson.dto.GrammarUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.GrammarLesson;
import com.btc.english_speak_free_lesson.service.GrammarLessonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/grammars")
@RequiredArgsConstructor
public class GrammarLessonController {

    private final GrammarLessonService service;

	@GetMapping
	public PageResponse<GrammarResponse> lgetGrammarLessonsist(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "level", required = false) String level) {
		return service.getGrammarPage(page, size, level);
	}

    @GetMapping("/{code}")
    public GrammarLesson detail(@PathVariable(name="code") String code) {
        return service.getByCode(code);
    }

    @PostMapping
    public GrammarLesson create(@RequestBody GrammarLesson lesson) {
        return service.save(lesson);
    }

	@PutMapping("/{id}")
	public GrammarResponse update(@PathVariable(name="id") Long id, @RequestBody GrammarUpdateRequest request) {
		return service.updateGrammar(id, request);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		service.deleteGrammarHard(id);
	}
}

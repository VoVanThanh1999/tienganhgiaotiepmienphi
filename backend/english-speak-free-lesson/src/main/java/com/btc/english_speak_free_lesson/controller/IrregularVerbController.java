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

import com.btc.english_speak_free_lesson.dto.IrregularVerbResponse;
import com.btc.english_speak_free_lesson.dto.IrregularVerbUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.IrregularVerb;
import com.btc.english_speak_free_lesson.service.IrregularVerbService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lessons/verbs")
@RequiredArgsConstructor
public class IrregularVerbController {

	private final IrregularVerbService service;

	@GetMapping
	public PageResponse<IrregularVerbResponse> list(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "0") int size,
			@RequestParam(required = false, name = "level") String level) {
		return service.getPage(page, size, level);
	}

	@GetMapping("/{v1}")
	public IrregularVerbResponse detail(@PathVariable(name = "v1") String v1) {
		return service.getDetail(v1);
	}
	
	@PostMapping
    public IrregularVerb save(@RequestBody IrregularVerb verb) {
        return service.save(verb);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name ="id") Long id) {
        service.delete(id);
    }

	@PutMapping("/{id}")
	public IrregularVerbResponse update(@PathVariable(name ="id") Long id, @RequestBody IrregularVerbUpdateRequest request) {
		return service.update(id, request);
	}
}

package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.btc.english_speak_free_lesson.dto.GrammarResponse;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.GrammarLesson;
import com.btc.english_speak_free_lesson.repository.GrammarLessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrammarLessonService {

	private final GrammarLessonRepository lessonRepo;

	public PageResponse<GrammarResponse> getGrammarPage(int page, int size, String level) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("orderIndex").ascending());

		Page<GrammarLesson> lessonPage;

		if (level == null || level.isBlank()) {
			lessonPage = lessonRepo.findAll(pageable);
		} else {
			lessonPage = lessonRepo.findByLevel(level, pageable);
		}

		List<GrammarResponse> responses = lessonPage.getContent().stream().map(this::toGrammarResponse).toList();

		return new PageResponse<>(responses, lessonPage.getNumber(), lessonPage.getSize(),
				lessonPage.getTotalElements(), lessonPage.getTotalPages());
	}

	public GrammarLesson getByCode(String code) {
		return lessonRepo.findByCode(code).orElseThrow(() -> new RuntimeException("Lesson not found"));
	}

	public GrammarLesson save(GrammarLesson lesson) {
		return lessonRepo.save(lesson);
	}

	private GrammarResponse toGrammarResponse(GrammarLesson lesson) {
		return new GrammarResponse(lesson.getId(), lesson.getCode(), lesson.getTitle(), lesson.getLevel(),
				lesson.getDescription(), lesson.getOverview());
	}
	
}

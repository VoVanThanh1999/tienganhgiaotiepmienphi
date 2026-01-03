package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.GrammarResponse;
import com.btc.english_speak_free_lesson.dto.GrammarUpdateRequest;
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

	@Transactional
	public GrammarResponse updateGrammar(Long id, GrammarUpdateRequest request) {
		GrammarLesson lesson = lessonRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Grammar lesson not found"));

		if (request.getTitle() != null) {
			lesson.setTitle(request.getTitle());
		}
		if (request.getLevel() != null) {
			lesson.setLevel(request.getLevel());
		}
		if (request.getDescription() != null) {
			lesson.setDescription(request.getDescription());
		}
		if (request.getOverview() != null) {
			lesson.setOverview(request.getOverview());
		}

		GrammarLesson saved = lessonRepo.save(lesson);
		return toGrammarResponse(saved);
	}
	
	@Transactional
	public void deleteGrammarHard(Long id) {
	    if (!lessonRepo.existsById(id)) {
	        throw new RuntimeException("Grammar lesson not found");
	    }
	    lessonRepo.deleteById(id);
	}

	public GrammarLesson save(GrammarLesson lesson) {
		return lessonRepo.save(lesson);
	}

	private GrammarResponse toGrammarResponse(GrammarLesson lesson) {
		return new GrammarResponse(lesson.getId(), lesson.getCode(), lesson.getTitle(), lesson.getLevel(),
				lesson.getDescription(), lesson.getOverview());
	}
	
}

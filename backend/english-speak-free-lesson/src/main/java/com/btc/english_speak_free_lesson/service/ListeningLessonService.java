package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.ListeningLessonResponse;
import com.btc.english_speak_free_lesson.dto.ListeningLessonUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.ListeningLesson;
import com.btc.english_speak_free_lesson.repository.ListeningLessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListeningLessonService {

	private final ListeningLessonRepository repo;

	/* ===== PAGE ===== */
	public PageResponse<ListeningLessonResponse> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

		Page<ListeningLesson> pageData = repo.findByActiveTrue(pageable);

		List<ListeningLessonResponse> responses = pageData.getContent().stream().map(this::toResponse).toList();

		return new PageResponse<>(responses, pageData.getNumber(), pageData.getSize(), pageData.getTotalElements(),
				pageData.getTotalPages());
	}

	/* ===== DETAIL ===== */
	public ListeningLessonResponse getDetail(Long id) {
		ListeningLesson lesson = repo.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));

		return toResponse(lesson);
	}

	/* ===== CREATE ===== */
	@Transactional
	public ListeningLessonResponse create(ListeningLesson lesson) {
		return toResponse(repo.save(lesson));
	}

	/* ===== UPDATE ===== */
	@Transactional
	public ListeningLessonResponse update(Long id, ListeningLessonUpdateRequest req) {
		ListeningLesson lesson = repo.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));

		if (req.getTitle() != null)
			lesson.setTitle(req.getTitle());
		if (req.getTopic() != null)
			lesson.setTopic(req.getTopic());
		if (req.getLevel() != null)
			lesson.setLevel(req.getLevel());
		if (req.getDuration() != null)
			lesson.setDuration(req.getDuration());
		if (req.getAudioUrl() != null)
			lesson.setAudioUrl(req.getAudioUrl());
		if (req.getSlowAudioUrl() != null)
			lesson.setSlowAudioUrl(req.getSlowAudioUrl());
		if (req.getTranscript() != null)
			lesson.setTranscript(req.getTranscript());

		return toResponse(repo.save(lesson));
	}

	/* ===== DELETE (SOFT) ===== */
	@Transactional
	public void delete(Long id) {
		ListeningLesson lesson = repo.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));

		lesson.setActive(false);
		repo.save(lesson);
	}

	private ListeningLessonResponse toResponse(ListeningLesson l) {
		return new ListeningLessonResponse(l.getId(), l.getTitle(), l.getTopic(), l.getLevel(), l.getDuration(),
				l.getAudioUrl(), l.getSlowAudioUrl(), l.getTranscript(), null);
	}
}

package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.ListeningQuestionResponse;
import com.btc.english_speak_free_lesson.dto.ListeningQuestionUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.ListeningQuestion;
import com.btc.english_speak_free_lesson.repository.ListeningQuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListeningQuestionService {

	private final ListeningQuestionRepository repo;

	/* ===== PAGE BY LESSON ===== */
	public PageResponse<ListeningQuestionResponse> getPage(Long lessonId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		Page<ListeningQuestion> pageData = repo.findByLessonId(lessonId, pageable);

		List<ListeningQuestionResponse> responses = pageData.getContent().stream().map(this::toResponse).toList();

		return new PageResponse<>(responses, pageData.getNumber(), pageData.getSize(), pageData.getTotalElements(),
				pageData.getTotalPages());
	}

	public ListeningQuestionResponse getDetail(Long id) {
		return toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Question not found")));
	}

	@Transactional
	public ListeningQuestionResponse create(ListeningQuestion q) {
		return toResponse(repo.save(q));
	}

	@Transactional
	public ListeningQuestionResponse update(Long id, ListeningQuestionUpdateRequest req) {
		ListeningQuestion q = repo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));

		if (req.getQuestion() != null)
			q.setQuestion(req.getQuestion());
		if (req.getOptions() != null)
			q.setOptions(req.getOptions());
		if (req.getCorrectIndex() != null)
			q.setCorrectIndex(req.getCorrectIndex());

		return toResponse(repo.save(q));
	}

	@Transactional
	public void delete(Long id) {
		repo.deleteById(id);
	}

	private ListeningQuestionResponse toResponse(ListeningQuestion q) {
		return new ListeningQuestionResponse(q.getId(), q.getLessonId(), q.getQuestion(), q.getOptions(),
				q.getCorrectIndex());
	}
	
}

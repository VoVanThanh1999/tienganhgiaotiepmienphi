package com.btc.english_speak_free_lesson.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.AdjectiveAdverbResponse;
import com.btc.english_speak_free_lesson.dto.AdjectiveAdverbUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.AdjectiveAdverb;
import com.btc.english_speak_free_lesson.repository.AdjectiveAdverbRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdjectiveAdverbService {

    private final AdjectiveAdverbRepository repo;

	/* ===== LIST PAGE ===== */

	public PageResponse<AdjectiveAdverbResponse> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("adjective").ascending());

		Page<AdjectiveAdverb> pageData;

		pageData = repo.findByActiveTrue(pageable);

		List<AdjectiveAdverbResponse> responses = pageData.getContent().stream().map(a -> toResponse(a, false))
				.toList();

		return new PageResponse<>(responses, pageData.getNumber(), pageData.getSize(), pageData.getTotalElements(),
				pageData.getTotalPages());
	}

	/* ===== DETAIL ===== */

	public AdjectiveAdverbResponse getDetail(String adjective) {
		AdjectiveAdverb entity = repo.findByAdjectiveAndActiveTrue(adjective)
				.orElseThrow(() -> new RuntimeException("Adjective not found: " + adjective));

		return toResponse(entity, true);
	}

	/* ===== SAVE ===== */

	@Transactional
	public AdjectiveAdverb save(AdjectiveAdverb entity) {
		return repo.save(entity);
	}

	/* ===== UPDATE ===== */

	@Transactional
	public AdjectiveAdverbResponse update(Long id, AdjectiveAdverbUpdateRequest request) {
		AdjectiveAdverb entity = repo.findById(id).orElseThrow(() -> new RuntimeException("AdjectiveAdverb not found"));

		if (request.getAdjective() != null) {
			entity.setAdjective(request.getAdjective());
		}
		if (request.getAdverb() != null) {
			entity.setAdverb(request.getAdverb());
		}
		if (request.getAdjectiveMeaning() != null) {
			entity.setAdjectiveMeaning(request.getAdjectiveMeaning());
		}
		if (request.getAdverbMeaning() != null) {
			entity.setAdverbMeaning(request.getAdverbMeaning());
		}
		if (request.getShortExample() != null) {
			entity.setShortExample(request.getShortExample());
		}
		if (request.getAdjectiveExamples() != null) {
			entity.setAdjectiveExamples(request.getAdjectiveExamples());
		}
		if (request.getAdverbExamples() != null) {
			entity.setAdverbExamples(request.getAdverbExamples());
		}
		if (request.getNote() != null) {
			entity.setNote(request.getNote());
		}

		AdjectiveAdverb saved = repo.save(entity);
		return toResponse(saved, true);
	}

	/* ===== DELETE (SOFT) ===== */

	@Transactional
	public void delete(Long id) {
		AdjectiveAdverb entity = repo.findById(id).orElseThrow(() -> new RuntimeException("AdjectiveAdverb not found"));

		entity.setActive(false);
		repo.save(entity);
	}

	/* ===== MAPPER ===== */

	private AdjectiveAdverbResponse toResponse(AdjectiveAdverb entity, boolean includeDetail) {
		return new AdjectiveAdverbResponse(entity.getId(), entity.getAdjective(), entity.getAdverb(),
				entity.getAdjectiveMeaning(), entity.getAdverbMeaning(), entity.getShortExample(),
				includeDetail ? entity.getAdjectiveExamples() : null, includeDetail ? entity.getAdverbExamples() : null,
				includeDetail ? entity.getNote() : null);
	}
}

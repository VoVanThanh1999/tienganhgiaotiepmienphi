package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.IrregularVerbResponse;
import com.btc.english_speak_free_lesson.dto.IrregularVerbUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.repository.IrregularVerbRepository;
import com.btc.english_speak_free_lesson.model.IrregularVerb;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IrregularVerbService {

	private final IrregularVerbRepository verbRepo;

	public PageResponse<IrregularVerbResponse> getPage(int page, int size, String level) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("v1").ascending());

		Page<IrregularVerb> pageData;

		if (level == null || level.isBlank() || level.equalsIgnoreCase("ALL")) {
			pageData = verbRepo.findByActiveTrue(pageable);
		} else {
			pageData = verbRepo.findByActiveTrueAndLevel(level, pageable);
		}

		List<IrregularVerbResponse> responses = pageData.getContent().stream().map(v -> toResponse(v, false)).toList();

		return new PageResponse<>(responses, pageData.getNumber(), pageData.getSize(), pageData.getTotalElements(),
				pageData.getTotalPages());
	}
	
	public IrregularVerbResponse getDetail(String v1) {
	    IrregularVerb verb = verbRepo.findByV1AndActiveTrue(v1)
	            .orElseThrow(() ->
	                    new RuntimeException("Irregular verb not found: " + v1));

	    return toResponse(verb, true);
	}
	
    @Transactional
    public IrregularVerb save(IrregularVerb verb) {
        return verbRepo.save(verb);
    }
    
	@Transactional
	public IrregularVerbResponse update(Long id, IrregularVerbUpdateRequest request) {
		IrregularVerb verb = verbRepo.findById(id).orElseThrow(() -> new RuntimeException("Irregular verb not found"));

		// ===== BASIC FIELDS =====
		if (request.getV1() != null) {
			verb.setV1(request.getV1());
		}
		if (request.getV2() != null) {
			verb.setV2(request.getV2());
		}
		if (request.getV3() != null) {
			verb.setV3(request.getV3());
		}
		if (request.getMeaning() != null) {
			verb.setMeaning(request.getMeaning());
		}
		if (request.getLevel() != null) {
			verb.setLevel(request.getLevel());
		}

		// ===== JSONB DETAIL =====
		if (request.getDetail() != null) {
			verb.setDetail(request.getDetail());
		}

		IrregularVerb saved = verbRepo.save(verb);
		return toResponse(saved, true);
	}
    
    @Transactional
    public void delete(Long id) {
        IrregularVerb verb = verbRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Irregular verb not found"));

        verb.setActive(false);
        verbRepo.save(verb);
    }
	
	private IrregularVerbResponse toResponse(IrregularVerb verb, boolean includeDetail) {
		return new IrregularVerbResponse(verb.getId(), verb.getV1(), verb.getV2(), verb.getV3(), verb.getMeaning(),
				verb.getLevel(), includeDetail ? verb.getDetail() : null);
	}
	
}

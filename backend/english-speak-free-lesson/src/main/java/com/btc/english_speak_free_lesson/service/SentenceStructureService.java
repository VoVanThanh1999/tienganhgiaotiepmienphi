package com.btc.english_speak_free_lesson.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btc.english_speak_free_lesson.dto.SentenceStructureResponse;
import com.btc.english_speak_free_lesson.dto.SentenceStructureUpdateRequest;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.SentenceStructure;
import com.btc.english_speak_free_lesson.repository.SentenceStructureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SentenceStructureService {

    private final SentenceStructureRepository repo;

    /* ===== LIST ===== */
    public PageResponse<SentenceStructureResponse> getPage(
            int page,
            int size
    ) {
        Pageable pageable =
                PageRequest.of(page, size, Sort.by("id").ascending());

        Page<SentenceStructure> pageData =
                repo.findByActiveTrue(pageable);

        List<SentenceStructureResponse> responses =
                pageData.getContent()
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return new PageResponse<>(
                responses,
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages()
        );
    }

    /* ===== DETAIL ===== */
    public SentenceStructureResponse getDetail(String code) {
        SentenceStructure entity = repo
                .findByCodeAndActiveTrue(code)
                .orElseThrow(() ->
                        new RuntimeException("Structure not found: " + code));

        return toResponse(entity);
    }

    /* ===== CREATE ===== */
    @Transactional
    public SentenceStructure save(SentenceStructure entity) {
        return repo.save(entity);
    }

    /* ===== UPDATE ===== */
    @Transactional
    public SentenceStructureResponse update(
            Long id,
            SentenceStructureUpdateRequest request
    ) {
        SentenceStructure entity = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Structure not found"));

        if (request.getTitle() != null) {
            entity.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            entity.setDescription(request.getDescription());
        }
        if (request.getFormula() != null) {
            entity.setFormula(request.getFormula());
        }
        if (request.getExamples() != null) {
            entity.setExamples(request.getExamples());
        }
        if (request.getNote() != null) {
            entity.setNote(request.getNote());
        }

        SentenceStructure saved = repo.save(entity);
        return toResponse(saved);
    }

    /* ===== DELETE (SOFT) ===== */
    @Transactional
    public void delete(Long id) {
        SentenceStructure entity = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Structure not found"));

        entity.setActive(false);
        repo.save(entity);
    }

    private SentenceStructureResponse toResponse(
            SentenceStructure e
    ) {
        return new SentenceStructureResponse(
                e.getId(),
                e.getCode(),
                e.getTitle(),
                e.getDescription(),
                e.getFormula(),
                e.getExamples(),
                e.getNote()
        );
    }
}

package com.btc.english_speak_free_lesson.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.btc.english_speak_free_lesson.dto.LessonCreateRequest;
import com.btc.english_speak_free_lesson.dto.LessonResponse;
import com.btc.english_speak_free_lesson.dto.base.PageResponse;
import com.btc.english_speak_free_lesson.model.Lesson;
import com.btc.english_speak_free_lesson.model.LessonContent;
import com.btc.english_speak_free_lesson.repository.LessonContentRepository;
import com.btc.english_speak_free_lesson.repository.LessonRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepo;
    private final LessonContentRepository contentRepo;

    // CREATE
    @Transactional
    public LessonResponse create(LessonCreateRequest req) {

        if (lessonRepo.findByCode(req.getCode()).isPresent()) {
            throw new RuntimeException("Lesson code already exists");
        }

        Lesson lesson = new Lesson();
        lesson.setCode(req.getCode());
        lesson.setTitle(req.getTitle());
        lesson.setImage(req.getImage());
        lesson.setSubTitle(req.getSubTitle());
        lesson.setLevel(req.getLevel());
        lesson.setOrderIndex(req.getOrderIndex());

        lessonRepo.save(lesson);

        LessonContent content = new LessonContent();
        content.setLessonId(lesson.getId());
        content.setContent(req.getContent());

        contentRepo.save(content);

        return toResponse(lesson, content.getContent());
    }

    // GET ALL (2 QUERY – KHÔNG N+1)
    public List<LessonResponse> getAll() {

        List<Lesson> lessons =
                lessonRepo.findByActiveTrueOrderByOrderIndexAsc();

        List<Long> ids = lessons.stream()
                .map(Lesson::getId)
                .toList();

        Map<Long, Map<String, Object>> contentMap =
                contentRepo.findByLessonIdIn(ids)
                        .stream()
                        .collect(Collectors.toMap(
                                LessonContent::getLessonId,
                                LessonContent::getContent
                        ));

        return lessons.stream()
                .map(l -> toResponse(l, contentMap.get(l.getId())))
                .toList();
    }

    // GET DETAIL
    public LessonResponse getByCode(String code) {

        Lesson lesson = lessonRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        LessonContent content = contentRepo.findByLessonId(lesson.getId())
                .orElseThrow(() -> new RuntimeException("Content not found"));

        return toResponse(lesson, content.getContent());
    }

    // UPDATE
    @Transactional
    public LessonResponse update(Long id, LessonCreateRequest req) {

        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lesson.setTitle(req.getTitle());
        lesson.setImage(req.getImage());
        lesson.setSubTitle(req.getSubTitle());
        lesson.setLevel(req.getLevel());
        lesson.setOrderIndex(req.getOrderIndex());

        LessonContent content = contentRepo.findByLessonId(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));

        content.setContent(req.getContent());

        return toResponse(lesson, content.getContent());
    }

    // DELETE (SOFT)
    public void delete(Long id) {

        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lesson.setActive(false);
        lessonRepo.save(lesson);
    }

	public PageResponse<LessonResponse> getPage(int page, int size, String level) {

		Pageable pageable = PageRequest.of(page, size, Sort.by("orderIndex").ascending());

		Page<Lesson> lessonPage;

		// FILTER TĨNH
		if (level == null || level.isBlank()) {
			lessonPage = lessonRepo.findByActiveTrue(pageable);
		} else {
			lessonPage = lessonRepo.findByActiveTrueAndLevel(level, pageable);
		}

		List<Lesson> lessons = lessonPage.getContent();

		List<Long> ids = lessons.stream().map(Lesson::getId).toList();

		Map<Long, Map<String, Object>> contentMap = contentRepo.findByLessonIdIn(ids).stream()
				.collect(Collectors.toMap(LessonContent::getLessonId, LessonContent::getContent));

		List<LessonResponse> responses = lessons.stream().map(l -> toResponse(l, contentMap.get(l.getId()))).toList();

		return new PageResponse<>(responses, lessonPage.getNumber(), lessonPage.getSize(),
				lessonPage.getTotalElements(), lessonPage.getTotalPages());
	}

    
    private LessonResponse toResponse(Lesson l, Map<String, Object> content) {
        return new LessonResponse(
                l.getId(),
                l.getCode(),
                l.getTitle(),
                l.getImage(),
                l.getSubTitle(),
                l.getLevel(),
                l.getOrderIndex(),
                l.getActive(),
                content
        );
    }
    
}


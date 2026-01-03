package com.btc.english_speak_free_lesson.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.btc.english_speak_free_lesson.model.AdjectiveAdverb;

public interface AdjectiveAdverbRepository extends JpaRepository<AdjectiveAdverb, Long> {

	Page<AdjectiveAdverb> findByActiveTrue(Pageable pageable);

	Optional<AdjectiveAdverb> findByAdjectiveAndActiveTrue(String adjective);
}
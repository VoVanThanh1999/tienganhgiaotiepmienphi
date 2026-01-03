package com.btc.english_speak_free_lesson.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.btc.english_speak_free_lesson.model.IrregularVerb;

public interface IrregularVerbRepository extends JpaRepository<IrregularVerb, Long> {

	Page<IrregularVerb> findByActiveTrue(Pageable pageable);

	Page<IrregularVerb> findByActiveTrueAndLevel(String level, Pageable pageable);

	Optional<IrregularVerb> findByV1AndActiveTrue(String v1);
}

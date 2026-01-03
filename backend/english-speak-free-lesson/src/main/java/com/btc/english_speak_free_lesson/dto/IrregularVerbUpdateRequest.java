package com.btc.english_speak_free_lesson.dto;

import com.btc.english_speak_free_lesson.model.data.VerbDetail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IrregularVerbUpdateRequest {
	private String v1;
	private String v2;
	private String v3;

	private String meaning;
	private String level;

	private VerbDetail detail;
}

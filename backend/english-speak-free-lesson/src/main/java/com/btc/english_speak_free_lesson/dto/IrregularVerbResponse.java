package com.btc.english_speak_free_lesson.dto;

import com.btc.english_speak_free_lesson.model.data.VerbDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IrregularVerbResponse {
	private Long id;
	private String v1;
	private String v2;
	private String v3;
	private String meaning;
	private String level;
	// ⚠️ Chỉ có khi DETAIL, list thì = null
	private VerbDetail detail;
}

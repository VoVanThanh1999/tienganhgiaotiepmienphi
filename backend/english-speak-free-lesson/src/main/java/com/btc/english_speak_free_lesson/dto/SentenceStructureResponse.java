package com.btc.english_speak_free_lesson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SentenceStructureResponse {

	private Long id;
	private String code;
	private String title;
	private String description;
	private String formula;
	private List<String> examples;
	private String note;
}

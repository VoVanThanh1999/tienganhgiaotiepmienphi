package com.btc.english_speak_free_lesson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdjectiveAdverbResponse {
	private Long id;

	private String adjective;
	private String adverb;

	private String adjectiveMeaning;
	private String adverbMeaning;

	private String shortExample;

	private List<String> adjectiveExamples;
	private List<String> adverbExamples;

	private String note;
}

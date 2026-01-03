package com.btc.english_speak_free_lesson.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ListeningQuestionUpdateRequest {

	private String question;
	private List<String> options;
	private Integer correctIndex;

}

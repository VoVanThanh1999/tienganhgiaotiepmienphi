package com.btc.english_speak_free_lesson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ListeningQuestionResponse {

	private Long id;
	private Long lessonId;
	private String question;
	private List<String> options;
	private Integer correctIndex;
}

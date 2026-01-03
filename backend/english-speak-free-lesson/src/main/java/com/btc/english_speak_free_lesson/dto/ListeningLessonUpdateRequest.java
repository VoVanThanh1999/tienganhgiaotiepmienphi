package com.btc.english_speak_free_lesson.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ListeningLessonUpdateRequest {

	private String title;
	private String topic;
	private String level;
	private Integer duration;
	private String audioUrl;
	private String slowAudioUrl;
	private String transcript;

}

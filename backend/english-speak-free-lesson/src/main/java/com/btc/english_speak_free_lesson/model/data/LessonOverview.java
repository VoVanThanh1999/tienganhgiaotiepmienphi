package com.btc.english_speak_free_lesson.model.data;

import java.util.List;

import lombok.Data;

@Data
public class LessonOverview {

	private List<String> whenToUse;

	private Structures structures;

	private List<Example> examples;

	private List<Exercise> exercises;
	
}

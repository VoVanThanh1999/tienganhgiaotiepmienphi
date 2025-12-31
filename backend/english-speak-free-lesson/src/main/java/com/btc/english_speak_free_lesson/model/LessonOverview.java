package com.btc.english_speak_free_lesson.model;

import java.util.List;

import com.btc.english_speak_free_lesson.model.data.Example;
import com.btc.english_speak_free_lesson.model.data.Exercise;
import com.btc.english_speak_free_lesson.model.data.Structures;

import lombok.Data;

@Data
public class LessonOverview {

	private List<String> whenToUse;

	private Structures structures;

	private List<Example> examples;

	private List<Exercise> exercises;
	
}

package com.btc.english_speak_free_lesson.model.data;

import java.util.List;
import lombok.Data;

@Data
public class VerbDetail {

	private String context; // mô tả ngữ cảnh

	private List<VerbExample> examples;

	private List<VerbExercise> exercises;

}

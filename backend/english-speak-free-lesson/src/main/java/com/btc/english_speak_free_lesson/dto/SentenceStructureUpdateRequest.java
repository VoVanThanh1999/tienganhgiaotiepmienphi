package com.btc.english_speak_free_lesson.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SentenceStructureUpdateRequest {

	private String title;
	private String description;
	private String formula;
	private List<String> examples;
	private String note;
}

package com.btc.english_speak_free_lesson.dto;


import com.btc.english_speak_free_lesson.model.data.LessonOverview;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GrammarResponse {
	Long id;
    String code;
    String title;
    String level;
    String description;
    LessonOverview overview;
}

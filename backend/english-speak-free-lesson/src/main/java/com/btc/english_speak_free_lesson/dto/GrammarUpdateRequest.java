package com.btc.english_speak_free_lesson.dto;

import com.btc.english_speak_free_lesson.model.data.LessonOverview;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GrammarUpdateRequest {
   private String title;
   private String level;
   private String description;
   private LessonOverview overview;
}

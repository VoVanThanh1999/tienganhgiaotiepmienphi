package com.btc.english_speak_free_lesson.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LessonResponse {

    private Long id;
    private String code;
    private String title;
    private String image;
    private String subTitle;
    private String level;
    private Integer orderIndex;
    private Boolean active;
    private Map<String, Object> content;
}

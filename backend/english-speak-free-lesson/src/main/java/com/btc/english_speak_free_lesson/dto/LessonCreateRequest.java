package com.btc.english_speak_free_lesson.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LessonCreateRequest {

    private String code;
    private String title;
    private String image;
    private String subTitle;
    private String level;
    private Integer orderIndex;

    private Map<String, Object> content;
}

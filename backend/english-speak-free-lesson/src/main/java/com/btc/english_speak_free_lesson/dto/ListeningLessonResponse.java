package com.btc.english_speak_free_lesson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class ListeningLessonResponse {

    private Long id;
    private String title;
    private String topic;
    private String level;
    private Integer duration;

    private String audioUrl;
    private String slowAudioUrl;

    private String transcript;
    private List<ListeningQuestionResponse> questions;
}


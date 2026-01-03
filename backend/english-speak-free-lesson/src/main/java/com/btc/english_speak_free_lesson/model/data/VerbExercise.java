package com.btc.english_speak_free_lesson.model.data;

import java.util.List;

import lombok.Data;

@Data
public class VerbExercise {

    private String question;

    private List<String> options;

    private String answer;
}

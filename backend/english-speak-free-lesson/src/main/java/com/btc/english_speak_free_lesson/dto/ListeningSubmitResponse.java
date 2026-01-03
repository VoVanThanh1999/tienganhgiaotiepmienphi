package com.btc.english_speak_free_lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ListeningSubmitResponse {

    private Long questionId;
    private boolean correct;
	
}

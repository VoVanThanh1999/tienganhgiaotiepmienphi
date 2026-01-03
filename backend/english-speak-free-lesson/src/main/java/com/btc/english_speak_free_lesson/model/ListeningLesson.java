package com.btc.english_speak_free_lesson.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "listening_lesson")
@Getter @Setter
public class ListeningLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;          // Luyện nghe giao tiếp
    private String topic;          // Chào hỏi nơi làm việc
    private String level;          // BEGINNER
    private Integer duration;      // 45 (seconds)

    private String audioUrl;       // normal speed
    private String slowAudioUrl;   // slow speed

    @Column(columnDefinition = "text")
    private String transcript;

    private Boolean active = true;
}


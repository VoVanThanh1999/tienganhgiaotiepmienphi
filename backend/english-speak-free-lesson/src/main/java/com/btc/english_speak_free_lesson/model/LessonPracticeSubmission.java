package com.btc.english_speak_free_lesson.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.btc.english_speak_free_lesson.model.data.PracticeType;

@Entity
@Table(name = "lesson_practice_submissions")
@Getter @Setter
public class LessonPracticeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // user làm bài
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // lesson chứa grammar practice
    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    // loại bài tập (GRAMMAR / WRITING / SPEAKING)
    @Enumerated(EnumType.STRING)
    @Column(name = "practice_type", nullable = false)
    private PracticeType practiceType;

    // nội dung user nhập (textarea / text / transcript)
    @Column(name = "user_answer", columnDefinition = "TEXT")
    private String userAnswer;

    // feedback GPT (tiếng Việt)
    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();
}

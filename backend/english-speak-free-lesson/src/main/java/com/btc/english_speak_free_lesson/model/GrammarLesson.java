package com.btc.english_speak_free_lesson.model;

import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grammar_lessons")
@Getter @Setter
public class GrammarLesson {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== BASIC INFO =====
    private String code;      // present-simple
    private String title;     // Present Simple
    private String level;     // beginner

    @Column(columnDefinition = "TEXT")
    private String description;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private LessonOverview overview;

    @Column(name = "order_index")
    private Integer orderIndex;
}

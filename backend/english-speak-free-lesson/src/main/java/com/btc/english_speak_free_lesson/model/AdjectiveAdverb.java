package com.btc.english_speak_free_lesson.model;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "adjective_adverb")
@Setter @Getter
public class AdjectiveAdverb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adjective;
    private String adverb;

    private String adjectiveMeaning;
    private String adverbMeaning;

    private String shortExample;

    // 🔥 LIST<String> → JSONB
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> adjectiveExamples;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> adverbExamples;

    private String note;
    private Boolean active = true;
}

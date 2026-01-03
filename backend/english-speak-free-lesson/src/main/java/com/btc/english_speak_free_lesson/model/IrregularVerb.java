package com.btc.english_speak_free_lesson.model;
import com.btc.english_speak_free_lesson.model.data.VerbDetail;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "irregular_verbs")
@Getter @Setter
public class IrregularVerb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== BASIC (TABLE LIST) =====
    private String v1;      // go
    private String v2;      // went
    private String v3;      // gone

    private String meaning; // đi
    private String level;   // BEGINNER / INTERMEDIATE

    private Boolean active = true;

    // ===== DETAIL (JSONB) =====
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private VerbDetail detail;
}

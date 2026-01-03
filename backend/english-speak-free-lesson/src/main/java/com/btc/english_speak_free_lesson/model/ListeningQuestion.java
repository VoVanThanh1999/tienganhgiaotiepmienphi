package com.btc.english_speak_free_lesson.model;

import java.util.List;

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
@Table(name ="listening_question")
@Getter @Setter
public class ListeningQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long lessonId;

	@Column(columnDefinition = "text")
	private String question;

	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
	private List<String> options;

	private Integer correctIndex;
}

package com.btc.english_speak_free_lesson.model;

import jakarta.persistence.Id;

import java.util.List;

import org.hibernate.annotations.Type;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sentence_structure")
@Getter
@Setter
public class SentenceStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// TOO / ENOUGH
	@Column(nullable = false, length = 50)
	private String code;

	// Too / Enough
	@Column(nullable = false, length = 100)
	private String title;

	// mô tả ngắn
	@Column(columnDefinition = "text")
	private String description;

	// too + adj + to V
	@Column(nullable = false, columnDefinition = "text")
	private String formula;

	// ví dụ mẫu
	@Type(JsonType.class)
	@Column(columnDefinition = "jsonb")
	private List<String> examples;

	// ghi chú
	@Column(columnDefinition = "text")
	private String note;

	private Boolean active = true;
}

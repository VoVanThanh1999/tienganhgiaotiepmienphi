package com.btc.english_speak_free_lesson.dto.base;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageResponse<T> {

	private List<T> items;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
	
}

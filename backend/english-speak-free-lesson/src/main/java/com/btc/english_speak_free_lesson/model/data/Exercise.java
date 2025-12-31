package com.btc.english_speak_free_lesson.model.data;
import java.util.List;
import lombok.Data;

@Data
public class Exercise {
	private String type; // FILL_BLANK | MULTIPLE_CHOICE
	private String question;
	private List<String> options; // null nếu fill blank
	private List<String> explains; // Giai thich ket qua
	private String answer;
}

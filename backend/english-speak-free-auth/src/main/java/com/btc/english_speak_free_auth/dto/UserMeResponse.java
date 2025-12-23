package com.btc.english_speak_free_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMeResponse {
	private Long id;
	private String email;
	private String role;
}

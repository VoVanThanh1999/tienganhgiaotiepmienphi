package com.btc.english_speak_free_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthResponse {
	private String accessToken;
	private String refreshToken;
    private String role;
}

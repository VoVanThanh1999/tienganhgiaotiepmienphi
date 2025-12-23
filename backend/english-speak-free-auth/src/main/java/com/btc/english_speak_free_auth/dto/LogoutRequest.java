package com.btc.english_speak_free_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutRequest {
	private String refreshToken;
}

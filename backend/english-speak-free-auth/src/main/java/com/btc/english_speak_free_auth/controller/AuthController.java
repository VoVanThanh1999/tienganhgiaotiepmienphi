package com.btc.english_speak_free_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btc.english_speak_free_auth.dto.AuthResponse;
import com.btc.english_speak_free_auth.dto.LoginRequest;
import com.btc.english_speak_free_auth.dto.LogoutRequest;
import com.btc.english_speak_free_auth.dto.RefreshTokenRequest;
import com.btc.english_speak_free_auth.dto.RegisterRequest;
import com.btc.english_speak_free_auth.dto.UserMeResponse;
import com.btc.english_speak_free_auth.model.User;
import com.btc.english_speak_free_auth.repository.UserRepository;
import com.btc.english_speak_free_auth.security.JwtUtil;
import com.btc.english_speak_free_auth.service.AuthService;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final JwtUtil jwtUtil;
	private final UserRepository userRepository;
	private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // ✅ REGISTER API
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @GetMapping("/me")
    public UserMeResponse me(@RequestParam(name = "token") String token) {
        Claims claims = jwtUtil.parseToken(token);
        Long userId = Long.valueOf(claims.getSubject());

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserMeResponse(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
    
    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody RefreshTokenRequest request) {
        return authService.refresh(request.getRefreshToken());
    }

	@PostMapping("/logout")
	public void logout(@RequestHeader("Authorization") String author,
			@RequestBody LogoutRequest logoutRequest			
		) {
		String accessToken = author.substring(7);
		authService.logout(accessToken, logoutRequest.getRefreshToken());
	}
}

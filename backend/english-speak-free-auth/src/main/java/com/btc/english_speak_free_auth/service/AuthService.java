package com.btc.english_speak_free_auth.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.btc.english_speak_free_auth.dto.AuthResponse;
import com.btc.english_speak_free_auth.dto.LoginRequest;
import com.btc.english_speak_free_auth.dto.RegisterRequest;
import com.btc.english_speak_free_auth.dto.UserMeResponse;
import com.btc.english_speak_free_auth.model.RefreshToken;
import com.btc.english_speak_free_auth.model.RevokedToken;
import com.btc.english_speak_free_auth.model.User;
import com.btc.english_speak_free_auth.repository.RefreshTokenRepository;
import com.btc.english_speak_free_auth.repository.RevokedTokenRepository;
import com.btc.english_speak_free_auth.repository.UserRepository;
import com.btc.english_speak_free_auth.security.JwtUtil;
import com.google.common.base.Optional;

import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${jwt.expiration}")
    private long refreshExpiration;
	
	private final UserRepository userRepository;
	private final RevokedTokenRepository revokedTokenRepository;
	private final RefreshTokenRepository refreshTokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public AuthResponse login(LoginRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		if (!user.isPresent()) {
			throw new RuntimeException("Invalid credentials");
		}
		if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}
		// Gen access token
        String accessToken = jwtUtil.generateToken(user.get());
        
        // Gen refresh token
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setUserId(user.get().getId());
        refreshToken.setExpiresAt(
        		Instant.now().plusMillis(refreshExpiration)       	
        );
        refreshTokenRepository.save(refreshToken);
        
        return new AuthResponse(accessToken, refreshToken.getToken(), user.get().getRole());
	}
	
	 // ✅ REGISTER + GEN TOKEN
    public AuthResponse register(RegisterRequest request) {
        // 1 Check email exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        // 2 Create new user
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        // 3️⃣ Save user
        userRepository.save(user);
        // 4️⃣ Generate JWT
        String accessToken = jwtUtil.generateToken(user);
        
        // 5 Gen refresh token
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setUserId(user.getId());
        refreshToken.setExpiresAt(
        		Instant.now().plusMillis(refreshExpiration)       	
        );
        refreshTokenRepository.save(refreshToken);
        
        return new AuthResponse(accessToken, refreshToken.getToken(), user.getRole());
    }
    
    public void logout(String accessToken, String refreshTokenValue) {
    	// Neu token da revoke roi -> ignore
    	if(revokedTokenRepository.existsByToken(accessToken)) {
    		return;
    	}
    	
    	// Revoked refresh token
    	refreshTokenRepository.findByToken(refreshTokenValue)
        .ifPresent(token -> {
            token.setRevoked(true);
            refreshTokenRepository.save(token);
        });
    	
    	Instant expiresAt = jwtUtil.getExpiration(accessToken);
    	RevokedToken revoked = new RevokedToken();
    	revoked.setToken(accessToken);
    	revoked.setExpiresAt(expiresAt);
    	revokedTokenRepository.save(revoked);
    }
    
    public String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }
    
	public AuthResponse refresh(String refreshTokenValue) {

		RefreshToken refreshToken = refreshTokenRepository.findByToken(refreshTokenValue)
				.orElseThrow(() -> new RuntimeException("Invalid refresh token"));

		if (refreshToken.isRevoked() || refreshToken.getExpiresAt().isBefore(Instant.now())) {
			throw new RuntimeException("Refresh token expired");
		}

		User user = userRepository.findById(refreshToken.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		String newAccessToken = jwtUtil.generateToken(user);

		return new AuthResponse(newAccessToken, refreshTokenValue, user.getRole());
	}
	
	@Transactional
	public void logoutAllDevices(String accessToken) {
		Claims claims = jwtUtil.parseToken(accessToken);
		Long userId = Long.valueOf(claims.getSubject());
		
		refreshTokenRepository.revokeAllByUserId(userId);
	}
	
	public UserMeResponse me(String token) {
		Claims claims = jwtUtil.parseToken(token);
		Long userId = Long.valueOf(claims.getSubject());

		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		return new UserMeResponse(user.getId(), user.getEmail(), user.getRole());
	}
}

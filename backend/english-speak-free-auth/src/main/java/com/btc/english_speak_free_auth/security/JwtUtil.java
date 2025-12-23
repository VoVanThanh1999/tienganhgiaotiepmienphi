package com.btc.english_speak_free_auth.security;

import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.btc.english_speak_free_auth.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(User user) {
        return Jwts.builder()
            .setSubject(user.getId().toString())
            .claim("role", user.getRole())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .compact();
    }
    
    public Claims parseToken(String token) {
    	return Jwts.parserBuilder()
    			.setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
    			.build()
    			.parseClaimsJws(token)
    			.getBody();
    }
    
    public Instant getExpiration(String token) {
        Claims claims = parseToken(token);
        return claims.getExpiration().toInstant();
    }
	
}

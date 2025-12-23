package com.btc.api_gateway.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "revoked_tokens")
@Setter @Getter
public class RevokedToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(length = 512, nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiresAt;
}

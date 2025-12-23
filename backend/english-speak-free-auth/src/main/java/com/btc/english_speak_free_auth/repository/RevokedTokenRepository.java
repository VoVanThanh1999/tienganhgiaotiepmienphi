package com.btc.english_speak_free_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_auth.model.RevokedToken;

@Repository
public interface RevokedTokenRepository extends JpaRepository<RevokedToken, Long>{
	
	boolean existsByToken(String token);
		
}

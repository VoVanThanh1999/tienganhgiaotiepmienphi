package com.btc.english_speak_free_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.btc.english_speak_free_auth.model.RefreshToken;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByToken(String token);
	
	void deleteAllByUserId(Long userId);
	
	 @Modifying
	    @Query("""
	        update RefreshToken rt
	        set rt.revoked = true
	        where rt.userId = :userId
	          and rt.revoked = false
	    """)
	void revokeAllByUserId(@Param("userId") Long userId);
}

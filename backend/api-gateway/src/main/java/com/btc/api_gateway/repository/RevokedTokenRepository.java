package com.btc.api_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btc.api_gateway.model.RevokedToken;


@Repository
public interface RevokedTokenRepository extends JpaRepository<RevokedToken, Long>{
	
	boolean existsByToken(String token);
	
}

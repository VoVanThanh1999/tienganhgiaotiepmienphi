package com.btc.english_speak_free_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btc.english_speak_free_auth.model.User;
import com.google.common.base.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}

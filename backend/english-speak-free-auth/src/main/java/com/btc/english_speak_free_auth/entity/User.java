package com.btc.english_speak_free_auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String email;
	private String password;

	private String fullName;

	private String role; // USER / ADMIN / CONTENT
	
}

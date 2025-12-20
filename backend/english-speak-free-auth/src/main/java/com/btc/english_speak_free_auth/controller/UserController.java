package com.btc.english_speak_free_auth.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class UserController {

	@GetMapping
	public List<String> getUser(){
		return List.of("user1@gmail.com", "user2@gmail.com");
	}

	@GetMapping("/me")
	public String me() {
		return "Current user info";
	}

}

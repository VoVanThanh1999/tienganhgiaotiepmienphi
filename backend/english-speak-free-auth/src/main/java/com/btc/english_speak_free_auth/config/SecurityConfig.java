package com.btc.english_speak_free_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				// ❌ TẮT HOÀN TOÀN UI LOGIN
				.formLogin(form -> form.disable()).httpBasic(basic -> basic.disable())
				// ❌ TẮT CSRF (API thuần)
				.csrf(csrf -> csrf.disable())
				// ✅ RULE API
				.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().denyAll())
				.build();
	}
}

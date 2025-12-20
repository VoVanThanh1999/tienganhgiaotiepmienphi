package com.btc.api_gateway.config;

import com.btc.api_gateway.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
 
 
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            // ❌ Gateway không dùng session
            .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
            .logout(ServerHttpSecurity.LogoutSpec::disable)
            .csrf(ServerHttpSecurity.CsrfSpec::disable)

            // ✅ Authorization rule
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/auth/**").permitAll()
                .anyExchange().permitAll() // JWT check làm ở WebFilter
            )

            .build();
    }
}

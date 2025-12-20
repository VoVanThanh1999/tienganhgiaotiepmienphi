package com.btc.api_gateway.security;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.btc.api_gateway.common.HeaderNames;
import com.google.common.net.HttpHeaders;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements WebFilter {
	private final JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // ✅ Public API
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorized(exchange);
        }

        String token = authHeader.substring(7);

        if (!jwtUtil.isValid(token)) {
            return unauthorized(exchange);
        }

        Claims claims = jwtUtil.getClaims(token);

        String userId = claims.getSubject();
        String role = claims.get("role", String.class);

        return chain.filter(
            exchange.mutate()
                .request(
                    exchange.getRequest()
                        .mutate()
                        .header(HeaderNames.USER_ID, userId)
                        .header(HeaderNames.USER_ROLE, role)
                        .build()
                )
                .build()
        );
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(430));
        return exchange.getResponse().setComplete();
    }
}

package com.btc.api_gateway.security;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.btc.api_gateway.common.HeaderNames;
import com.btc.api_gateway.repository.RevokedTokenRepository;
import com.google.common.net.HttpHeaders;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements WebFilter {

	private final JwtUtil jwtUtil;
	private final RevokedTokenRepository revokedTokenRepository;

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
            return forbidden(exchange);
        }

        String token = authHeader.substring(7);

        if (!jwtUtil.isValid(token)) {
            return forbidden(exchange);
        }
        
         // ❌ TOKEN ĐÃ LOGOUT
        if (revokedTokenRepository.existsByToken(token)) {
            exchange.getResponse().setRawStatusCode(HttpStatus.SC_UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // 3️⃣ Extract claims
        Claims claims = jwtUtil.getClaims(token);
        String userId = claims.getSubject();
        String role = claims.get("role", String.class);
        
        // 4. Add hearder
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

	private boolean isAuthorized(String path, String role) {

		if (path.startsWith("/admin")) {
			return RoleConstants.ADMIN.equals(role);
		}

		if (path.startsWith("/lessons") || path.startsWith("/speaking")) {
			return RoleConstants.USER.equals(role) || RoleConstants.ADMIN.equals(role);
		}

		// default: allow
		return true;
	}

	private Mono<Void> forbidden(ServerWebExchange exchange) {
		exchange.getResponse().setRawStatusCode(HttpStatus.SC_FORBIDDEN);
		return exchange.getResponse().setComplete();
	}
}

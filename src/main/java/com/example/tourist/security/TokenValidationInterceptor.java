package com.example.tourist.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenValidationInterceptor implements HandlerInterceptor {
    private static final String VALID_TOKEN = "VERY_SECRET_TOKEN";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        if ("DELETE".equalsIgnoreCase(request.getMethod())) {
            String token = request.getHeader("Token");
            if (!VALID_TOKEN.equals(token)) {
                throw new InvalidTokenException("Invalid token");
            }
        }
        return true;
    }
}

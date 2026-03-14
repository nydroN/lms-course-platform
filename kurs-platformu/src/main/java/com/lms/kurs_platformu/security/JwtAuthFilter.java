package com.lms.kurs_platformu.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--- GÜVENLİK KONTROLÜ BAŞLADI ---");
        System.out.println("İstek Yapılan Adres: " + request.getRequestURI());

        final String authHeader = request.getHeader("Authorization");
        System.out.println("Gelen Authorization Başlığı: " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("HATA: Başlık yok veya 'Bearer ' ile başlamıyor! Kapıdan çevrildi.");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            final String userEmail = jwtService.extractUsername(jwt);
            System.out.println("Token'dan okunan e-posta: " + userEmail);

            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtService.isTokenValid(jwt)) {
                    System.out.println("BAŞARILI: Token geçerli! Kullanıcı içeri alınıyor.");
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userEmail, null, new ArrayList<>()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    System.out.println("HATA: Token geçersiz veya süresi dolmuş!");
                }
            }
        } catch (Exception e) {
            System.out.println("KRİTİK HATA: Token okunurken bir sorun çıktı: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
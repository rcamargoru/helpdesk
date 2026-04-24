/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.model.SesionUsuario;
import com.hdrc.auth_service.repository.ISesionUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Administrador
 */
@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter{

    private final TokenService tokenService;
    private final ISesionUsuario sesionRepository;

    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain)
//            throws ServletException, IOException, java.io.IOException {
//
//        String header = request.getHeader("Authorization");
//
//        String path = request.getServletPath();
//
//if (path.contains("api/v1/auth/login")) {
//    filterChain.doFilter(request, response);
//    return;
//}
//        
//         🔹 1. Validar header
//        if (header == null || !header.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = header.substring(7);
//
//        try {
//             🔹 2. Extraer datos del token
//            String username = tokenService.extraerUsuario(token);
//            String sessionId = tokenService.extraerSessionId(token);
//
//             🔹 3. Validar sesión en BD
//            SesionUsuario sesion = sesionRepository
//                    .findBySesionPrimIdAndActivoTrue(sessionId)
//                    .orElse(null);
//
//            if (sesion == null) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//
//             🔹 4. Extraer roles y permisos del token
//            List<String> roles = tokenService.extraerRoles(token);
//            List<String> permisos = tokenService.extraerPermisos(token);
//
//             🔹 5. Convertir a authorities
//            List<SimpleGrantedAuthority> authorities = Stream.concat(
//                    roles.stream(),
//                    permisos.stream()
//            )
//                    .map(SimpleGrantedAuthority::new)
//                    .distinct()
//                    .toList();
//
//             🔹 6. Crear autenticación
//            UsernamePasswordAuthenticationToken auth
//                    = new UsernamePasswordAuthenticationToken(
//                            username, // puedes usar Usuario si quieres
//                            null,
//                            authorities
//                    );
//
//            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//             🔹 7. Registrar en contexto
//            SecurityContextHolder.getContext().setAuthentication(auth);
//
//        } catch (Exception e) {
//             🔥 IMPORTANTE: no romper la app
//             puedes loggear aquí
//        }
//
//        filterChain.doFilter(request, response);
//    }
    protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {
System.out.println("FILTER PATH: " + request.getServletPath());
System.out.println("URI: " + request.getRequestURI());
System.out.println("AUTH HEADER: " + request.getHeader("Authorization"));
    SecurityContextHolder.clearContext(); // 🔥 importante
String path = request.getRequestURI();


if (path.startsWith("/api/v1/auth/")) {
    filterChain.doFilter(request, response);
    return;
}

    filterChain.doFilter(request, response);
}
}

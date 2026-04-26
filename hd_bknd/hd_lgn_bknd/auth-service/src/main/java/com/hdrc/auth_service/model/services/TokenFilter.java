/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;


import com.hdrc.auth_service.repository.ISesionUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Administrador
 */
@Component
public class TokenFilter extends OncePerRequestFilter{

    private final TokenService jwtService;
    private final AuthUserDetails userDetailsService;
    private final ISesionUsuario sesionRepository;  
    
    public TokenFilter(TokenService jwtService,
                     AuthUserDetails userDetailsService,
                     ISesionUsuario sesionRepository) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.sesionRepository = sesionRepository;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        // header
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = authHeader.substring(7);

        try {

            // token
            if (!jwtService.isTokenValid(token)) {
                filterChain.doFilter(request, response);
                return;
            }

            //ext usuario
            String username = jwtService.extraerUsuario(token);
            String sessionId = jwtService.getClaims(token).get("sessionId", String.class);
            
            if (username == null || sessionId == null ||
                SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }

            //comparacion token contra db
            boolean sesionValida = sesionRepository.existsBySesionPrimIdAndActivoTrue(sessionId);

            if (!sesionValida) {
                filterChain.doFilter(request, response);
                return;
            }

            //1. Cargar usuario (UserDetailsService)
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            //2.Crear autenticación con permisos dinámicos
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // 🔥 7. Setear contexto
            SecurityContextHolder.getContext().setAuthentication(authToken);

        } catch (Exception e) {
            // 🔥 Seguridad: no explotar el request
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
    
    
}
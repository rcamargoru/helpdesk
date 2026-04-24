/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpdesk.util;

import com.jr.jr.helpDesk.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Ricardo
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  
    @Autowired
    private JwtUtil jwtUtilService;
    
    
        private final JwtUtil jwtService;

    public JwtRequestFilter(JwtUtil jwtService) {
        this.jwtService = jwtService;
    }
    
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
 
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtilService.extractUsername(jwt);
List<String> roles =jwtUtilService.extractRoles(jwt);
  if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Convertir los roles en autoridades (GrantedAuthority)
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toList());

                // Crear un objeto UserDetails con los roles y el usuario
                UserDetails userDetails = new User(username, "", authorities);

                // Crear un token de autenticación con las autoridades
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, authorities);

                // Establecer el contexto de seguridad con la autenticación
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continuar con la cadena de filtros
        
        filterChain.doFilter(request, response);
    }
    


private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }



}

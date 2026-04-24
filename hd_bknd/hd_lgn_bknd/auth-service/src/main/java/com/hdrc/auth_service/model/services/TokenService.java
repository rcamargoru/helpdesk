/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Rc
 */
@Service
public class TokenService {
    
    @Value("${JWT_MASTERSECRET}")
    private String MasterSecret;
 
    public String generarAccessToken(String userId, String sessionId,List<String> roles, List<String> permisos) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("sessionId", sessionId)
                .claim("roles", roles)
                .claim("permisos", permisos)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 min
                .signWith(HS256, MasterSecret)
                .compact();
    }    
    
     public String generarRefreshToken(String userId, String sessionId) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("sessionId", sessionId) // 🔥 AQUÍ TAMBIÉN
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7)) // 7 días
                .signWith(HS256, MasterSecret)
                .compact();
    }  
     
      public String extraerUsuario(String token) {
        return getClaims(token).getSubject();
    }

    public String extraerSessionId(String token) {
        return getClaims(token).get("sessionId", String.class);
    }

    public List<String> extraerRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }

    public List<String> extraerPermisos(String token) {
        return getClaims(token).get("permisos", List.class);
    }

    private Claims getClaims(String token) {
    return Jwts.parser()
    .setSigningKey(MasterSecret)
    .build()
    .parseClaimsJws(token)
    .getBody();
    }   
     
}

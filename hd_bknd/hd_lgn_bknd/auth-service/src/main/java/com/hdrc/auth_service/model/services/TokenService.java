/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import java.util.Date;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import io.jsonwebtoken.security.Keys;
import java.util.List;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;

/**
 *
 * @author Rc
 */
@Service
public class TokenService {
    
    @Value("${JWT_MASTERSECRET}")
    private String MasterSecret;
    private final long AccExp = 1000 * 60 * 15; // 15 min
    private final long RfhExp = 1000L * 60 * 60 * 24 * 7; // 7 días
    
   private SecretKey getKey() {
        return Keys.hmacShaKeyFor(MasterSecret.getBytes());
    }
   
   
    public String generateAccessToken(String username, List<String> permisos, String sessionId) {
        System.out.println("asdasd");
        return Jwts.builder()
                .setSubject(username)
                .claim("permissions", permisos)
                .claim("sessionId", sessionId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + AccExp))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    public String generateRefreshToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .claim("type", "refresh")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + RfhExp))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
     
      public String extraerUsuario(String token) {
        return getClaims(token).getSubject();
    }

      
          public boolean isTokenValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
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
public Claims getClaims(String token) {
    return Jwts.parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
}

}

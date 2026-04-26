/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.dto.AuthRequestDto;
import com.hdrc.auth_service.dto.AuthResponseDto;
import com.hdrc.auth_service.model.SesionUsuario;
import com.hdrc.auth_service.model.Usuario;
import com.hdrc.auth_service.repository.ISesionUsuario;
import com.hdrc.auth_service.repository.IUsuario;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
//@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final IUsuario usuarioRepository;
    private final TokenService tokenService;
     private final AuthorityService authorityService;
    private final ISesionUsuario sesionRepository;

    
    public AuthService(TokenService jwtService,
                        IUsuario usuarioRepository,
                        ISesionUsuario sesionRepository,
                        AuthorityService authorityService,AuthenticationManager authenticationManager) {
        this.tokenService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.sesionRepository = sesionRepository;
        this.authorityService = authorityService;
        this.authenticationManager = authenticationManager;
    }    
      
    
    public AuthResponseDto login(AuthRequestDto request, HttpServletRequest httpRequest) {

        // 🔥 1. Autenticación real con Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.usuario(),
                        request.clave()
                )
        );

        // 🔥 2. Obtener usuario
        Usuario usuario = usuarioRepository.findByNombreLgnUsuario(request.usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        System.out.println("pare");
        // 🔥 3. Permisos dinámicos
        List<String> permisos = authorityService.getPermisos(usuario);

        // 🔥 4. Generar sessionId
        String sessionId = UUID.randomUUID().toString();

        // 🔥 5. Crear tokens
        String accessToken = tokenService.generateAccessToken(
                request.usuario(),
                permisos,
                sessionId
        );

        String refreshToken = tokenService.generateRefreshToken(request.usuario());

        // 💾 6. Guardar sesión
        SesionUsuario sesion = new SesionUsuario();
        sesion.setUsuario(usuario);
        sesion.setRefreshToken(refreshToken);
        sesion.setSesionPrimId(sessionId);
        sesion.setFechaCreacion(LocalDateTime.now());
        sesion.setFechaExpiracion(LocalDateTime.now().plusDays(7));
        sesion.setActivo(true);
        //sesion.setIpCliente(ip);
        //sesion.setDispositivo(device);

        sesionRepository.save(sesion);

        return new AuthResponseDto(accessToken, refreshToken);
    }
}

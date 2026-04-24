/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

//import com.hdrc.auth_service.repository.ISesionRepository;
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
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final IUsuario usuarioRepository;
    private final TokenService tokenService;
    private final ISesionUsuario sesionRepository;

    public AuthResponseDto login(AuthRequestDto request, HttpServletRequest httpRequest) {

        // 1. AUTENTICACIÓN (Spring valida password aquí)
        System.out.println("");
        
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.usuario(),
                        request.clave()
                )
        );

        // 2. SOLO CARGA BÁSICA (SIN JOIN FETCH PROFUNDO)
        Usuario usuario = usuarioRepository
                .findByNombreLgnUsuario(request.usuario())
                .orElseThrow();

        // 3. SOLO ROLES (NO PERMISOS AQUÍ)
        List<String> roles = usuario.getUsuarioRoles()
                .stream()
                .map(ur -> "ROLE_" + ur.getRol().getNombreRolAuth())
                .distinct()
                .toList();

        // 4. SESSION ID
        String sessionId = UUID.randomUUID().toString();

        // 5. TOKEN
        String accessToken = tokenService.generarAccessToken(
                usuario.getIdUsuarioAuth().toString(),
                sessionId,
                roles,
                List.of() // permisos fuera del login
        );

        String refreshToken = tokenService.generarRefreshToken(
                usuario.getIdUsuarioAuth().toString(),
                sessionId
        );

        // 6. SESIÓN
        SesionUsuario sesion = new SesionUsuario();
        sesion.setUsuario(usuario);
        sesion.setSesionPrimId(sessionId);
        sesion.setRefreshToken(refreshToken);
        sesion.setFechaCreacion(LocalDateTime.now());
        sesion.setFechaExpiracion(LocalDateTime.now().plusDays(7));
        sesion.setActivo(true);
        sesion.setDispositivo(httpRequest.getHeader("User-Agent"));

        sesionRepository.save(sesion);

        // 7. RESPONSE
        return new AuthResponseDto(accessToken, refreshToken);
    }
}
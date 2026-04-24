/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.controller;

import com.hdrc.auth_service.dto.AuthRequestDto;
import com.hdrc.auth_service.dto.AuthResponseDto;
import com.hdrc.auth_service.model.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UsuarioController {

private final AuthService authService;
    
@PostMapping("/login")    
public ResponseEntity<AuthResponseDto> login(
 @RequestBody AuthRequestDto request, HttpServletRequest httpRequest){
return ResponseEntity.ok(authService.login(request, httpRequest));
        }

    
}

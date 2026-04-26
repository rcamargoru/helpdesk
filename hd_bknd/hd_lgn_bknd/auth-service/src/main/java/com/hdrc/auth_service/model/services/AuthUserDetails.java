/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.model.Usuario;
import com.hdrc.auth_service.repository.IUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class AuthUserDetails implements UserDetailsService {
        private final IUsuario usuarioRepository;
    private final AuthorityService authorityService;

    public AuthUserDetails(IUsuario usuarioRepository,
                                    AuthorityService authorityService) {
        this.usuarioRepository = usuarioRepository;
        this.authorityService = authorityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Usuario usuario = usuarioRepository.findByNombreLgnUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                usuario.getNombreUsuario(),
                usuario.getHashPwd(),
                authorityService.getAuthorities(usuario)
        );
    }
}

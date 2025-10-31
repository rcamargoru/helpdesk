/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.service;

import com.jr.jr.loginapp.model.Usuario;
import com.jr.jr.loginapp.model.UsuarioRol;
import com.jr.jr.loginapp.repository.IUserRepo;
import com.jr.jr.loginapp.repository.IUsuarioRolRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ricardo
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepo iUserRepo;
    
        @Autowired
    private IUsuarioRolRepo iUsuarioRolRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usuario usuario = this.iUserRepo.findBynombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //buscar los roles
         List<UsuarioRol> usuarioRoles = iUsuarioRolRepo.findByUsuario(usuario.getIdUsuario());
                 // Convertir la lista de roles en una lista de GrantedAuthority
        List<GrantedAuthority> authorities = usuarioRoles.stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getRol().getNombreRol()))
                .collect(Collectors.toList()) ;
                return new User(usuario.getNombreUsuario(), usuario.getPassword(),authorities);
    }
}

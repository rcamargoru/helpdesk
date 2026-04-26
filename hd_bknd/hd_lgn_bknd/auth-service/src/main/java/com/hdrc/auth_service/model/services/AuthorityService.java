/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.model.Permiso;
import com.hdrc.auth_service.model.RolPermiso;
import com.hdrc.auth_service.model.Usuario;
import com.hdrc.auth_service.model.UsuarioRol;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class AuthorityService {
 /**
     * Permisos como String (para JWT)
     */
    public List<String> getPermisos(Usuario usuario) {

    if (usuario == null || usuario.getUsuarioRoles() == null) {
        return Collections.emptyList();
    }

usuario.getUsuarioRoles().forEach(ur -> {

});
usuario.getUsuarioRoles().stream()
    .map(UsuarioRol::getRol)
    .filter(Objects::nonNull)
    .forEach(rol -> {
        System.out.println("Rol: " + rol.getNombreRolAuth());
        System.out.println("Permisos: " + rol.getRolesPermiso().size());
    });

    return usuario.getUsuarioRoles()
            .stream()
            
            .filter(UsuarioRol::isVigente)
            .map(UsuarioRol::getRol)
            .filter(Objects::nonNull)
            .flatMap(rol -> rol.getRolesPermiso().stream())
            .filter(rp -> Boolean.TRUE.equals(rp.isActivo()))
            .map(RolPermiso::getPermiso)
            .filter(Objects::nonNull)
            .map(Permiso::getCodigoPermisoAuth)
            .filter(Objects::nonNull)
            .distinct()
            
            .toList();
    
    }

    /**
     * Permisos como Authorities (Spring Security)
     */
public List<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
    
    if (usuario == null || usuario.getUsuarioRoles() == null) {
        return Collections.emptyList();
    }

    return getPermisos(usuario)
            .stream()
            .map(SimpleGrantedAuthority::new)
            .toList();
}

    /**
     * Validación manual de permisos
     */
    public boolean hasPermission(Usuario usuario, String permiso) {
        return getPermisos(usuario).contains(permiso);
    } 
}

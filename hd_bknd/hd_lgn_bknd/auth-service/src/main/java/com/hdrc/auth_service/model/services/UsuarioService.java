/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hdrc.auth_service.model.services;

import com.hdrc.auth_service.model.Usuario;
import com.hdrc.auth_service.repository.IUsuario;
//import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service 
public class UsuarioService {
    
    private final IUsuario usuarioRepository;

    public UsuarioService(IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    public Usuario obtenerUsuario(Long id) {
//        return usuarioRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//    }

//    public List<Usuario> obtenerTodos() {
//        return usuarioRepository.findAll();
//    }

public Usuario obtenerPorLogin(String login) {
    return usuarioRepository.findByNombreLgnUsuario(login)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
} 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jr.jr.loginapp.repository;

import com.jr.jr.loginapp.model.Usuario;
import com.jr.jr.loginapp.model.UsuarioRol;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface IUsuarioRolRepo {
 List<UsuarioRol> findByUsuario(long usuario);   
}

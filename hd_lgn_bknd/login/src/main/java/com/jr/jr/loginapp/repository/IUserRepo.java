/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jr.jr.loginapp.repository;

import com.jr.jr.loginapp.model.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IUserRepo {
  public Usuario findBynombreUsuario (String nombreUsuario); 
}

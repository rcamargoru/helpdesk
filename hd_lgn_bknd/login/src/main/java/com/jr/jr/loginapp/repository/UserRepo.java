/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.repository;

import com.jr.jr.loginapp.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public class UserRepo implements IUserRepo{

    @PersistenceContext
    private EntityManager entityManager;    
    
    @Override
    public Usuario findBynombreUsuario(String nombreUsuario) {
        //System.out.println("sdfsf");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //String sql = "SELECT * FROM GnUsuario WHERE nombreUsuario=?"; // Ajusta el nombre de la tabla a tu base de datos
        String sql = "SELECT * FROM GnUsuario WHERE nombreUsuario=?";
        Query query = entityManager.createNativeQuery(sql, Usuario.class);
        query.setParameter(1, nombreUsuario);
        return (Usuario) query.getSingleResult();
    }

    
}

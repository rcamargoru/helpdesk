/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.repository;


import com.jr.jr.loginapp.model.UsuarioRol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public class UsuarioRolRepo implements IUsuarioRolRepo{

    @PersistenceContext
    private EntityManager entityManager;  
    
    @Override
    public List<UsuarioRol> findByUsuario(long Usuario) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String sql = "SELECT * FROM GnUsuarioRol WHERE usuario=?";
        Query query = entityManager.createNativeQuery(sql, UsuarioRol.class);
        query.setParameter(1, Usuario);
        return query.getResultList();
    }
    
}

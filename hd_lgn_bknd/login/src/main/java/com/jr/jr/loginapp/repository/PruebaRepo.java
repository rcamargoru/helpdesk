/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.repository;

import com.jr.jr.loginapp.model.Prioridad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ricardo
 */

@Repository
public class PruebaRepo implements  IPruebaRepo{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Prioridad> findAll() {
        String sql = "SELECT * FROM HdPrioridad"; // Ajusta el nombre de la tabla a tu base de datos
        Query query = entityManager.createNativeQuery(sql, Prioridad.class);
        return query.getResultList();
}
}

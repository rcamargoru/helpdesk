/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.service;

import com.jr.jr.loginapp.model.Prioridad;
import com.jr.jr.loginapp.repository.IPruebaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */
@Service
public class PruebaService implements  IPruebaService{

    @Autowired
    private IPruebaRepo iPruebaRepo;
    
    @Override
    public List<Prioridad> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          List<Prioridad> list;
        try{
            list = iPruebaRepo.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }
    }
    

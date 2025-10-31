/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.controller;

import com.jr.jr.loginapp.model.Usuario;
import com.jr.jr.loginapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ricardo
 */
@Controller
@RequestMapping("api/v3/auth")
public class UserController {

    @Autowired
    UserRepo userRepo;

    // Obtener una prioridad por su ID
    @GetMapping("/listarn/{nombre}")
    public ResponseEntity<Usuario> findBynombreUsuario(@PathVariable String nombre) {
        System.out.println("asdsfdsdf");
        Usuario Usuario = userRepo.findBynombreUsuario(nombre);
        if (Usuario != null) {
            return new ResponseEntity<>(Usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

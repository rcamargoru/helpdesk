/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.controller;

import com.jr.jr.loginapp.model.Prioridad;
import com.jr.jr.loginapp.service.IPruebaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ricardo
 */
@Controller
@RequestMapping("api/v3")
public class PruebaController {
 
@Autowired
IPruebaService pruebaService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<Prioridad> products = this.pruebaService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

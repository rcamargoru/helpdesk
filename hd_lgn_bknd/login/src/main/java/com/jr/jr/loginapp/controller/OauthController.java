/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.controller;

/**
 *
 * @author Ricardo
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class OauthController {
      @GetMapping("Admin")
     @ResponseBody
     @PreAuthorize("hasAuthority('APPROLE_Admin')")
     public String Admin() {
         return "Admin message";   
}
}

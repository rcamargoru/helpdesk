/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.model;

import java.util.List;

public class AuthenticationResponse {

    private final String jwt;
    private final List<String> roles;

    public AuthenticationResponse(String jwt, List<String> roles) {
        this.jwt = jwt;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public List<String> getRoles() {
        return roles;
    }
}

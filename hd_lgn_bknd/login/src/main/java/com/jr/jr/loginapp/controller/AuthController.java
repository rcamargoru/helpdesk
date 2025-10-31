/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.loginapp.controller;

import com.jr.jr.loginapp.dto.AuthRequestdto;
import com.jr.jr.loginapp.dto.AuthResponsedto;
import com.jr.jr.loginapp.model.Usuario;
import com.jr.jr.loginapp.repository.UserRepo;
import com.jr.jr.loginapp.service.JwtUtilService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Ricardo
 */
@Controller
@RequestMapping("api/v3/auth")
public class AuthController {

    @Autowired
    private UserRepo UserRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @PostMapping("/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequestdto authRequestDto) {
        try {
              if (authRequestDto.getUser() == null || authRequestDto.getPassword() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario y la contraseña son obligatorios.");
            }
            //1. Gestion authenticationManager
            //System.out.println("authRequestDto.getUser()"+authRequestDto.getUser());
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequestDto.getUser(), authRequestDto.getPassword()
            ));
            //2. Validar el usuario en la bd
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequestDto.getUser());
            Usuario usuario = this.UserRepo.findBynombreUsuario(authRequestDto.getUser());
                        if (usuario == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado.");
            }
                        
            //3. Generar token
            String jwt = this.jwtUtilService.generateToken(usuario.getNombre(), usuario.getApellido(), userDetails);
            String refreshToken = this.jwtUtilService.generateRefreshToken(usuario.getNombre(), usuario.getApellido(), userDetails);
            AuthResponsedto authResponseDto = new AuthResponsedto();
            authResponseDto.setToken(jwt);
            authResponseDto.setRefreshToken(refreshToken);
            return new ResponseEntity<AuthResponsedto>(authResponseDto, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error Authentication:::" + e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
        //return null;

    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> auth(@RequestBody Map<String,String> request) {
        
        String refreshToken= request.get("refreshToken");
        try {
 String username=jwtUtilService.extractUsername(refreshToken);
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
            Usuario usuario = this.UserRepo.findBynombreUsuario(username);
            if(jwtUtilService.validateToken(refreshToken, userDetails)){
                String newJwt=jwtUtilService.generateRefreshToken(usuario.getNombre(), usuario.getApellido(), userDetails);
                String newRefreshToken = jwtUtilService.generateRefreshToken(usuario.getNombre(), usuario.getApellido(), userDetails);
                AuthResponsedto authResponsedto =new AuthResponsedto();
            authResponsedto.setToken(newJwt);
            authResponsedto.setRefreshToken(newRefreshToken);
            return new ResponseEntity<>(authResponsedto,HttpStatus.OK);
            }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Refresh Token");
            }

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error refresh token:::" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
        //return null;

    }
    
    

}

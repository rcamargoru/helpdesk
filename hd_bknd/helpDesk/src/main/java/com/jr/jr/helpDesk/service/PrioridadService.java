/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.service;

import com.jr.jr.helpDesk.model.Prioridad;
import com.jr.jr.helpDesk.model.Usuario;
import com.jr.jr.helpDesk.repository.PrioridadRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Ricardo
 */
@Service
public class PrioridadService {

     private final WebClient webClient;

    @Autowired
    public PrioridadService(WebClient prioridadService) {
        this.webClient = prioridadService;
    }
    
    
       public Usuario obtenerUsuarioPorNombre(String nombre, String tokenJwt) {
        System.out.println("asdfasdfsdf");
        try {
            return webClient.get().uri("/api/v3/auth/listarn/{nombre}", nombre)
    .headers(headers -> headers.set(HttpHeaders.AUTHORIZATION, "Bearer "+tokenJwt))
                    .retrieve()
                    .bodyToMono(Usuario.class)
                    .block();
        } catch (Exception e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    private HttpHeaders createHeaders(String tokenJwt) {
        // Este método crea los encabezados HTTP con el token JWT
        HttpHeaders headers = new HttpHeaders();  
       headers.set("AUTHORIZATION", "Bearer " + tokenJwt);  // Agregamos el token JWT al encabezado
        return headers;
    }

    @Autowired
    private PrioridadRepo prioridadRepository;

    // Crear una prioridad
    public Prioridad crearPrioridad(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    // Obtener todas las prioridades
    public List<Prioridad> obtenerPrioridades() {
        System.out.println("adfsfdsdfsdf");
        return prioridadRepository.findAll();
    }

    // Obtener prioridad por ID
    public Prioridad obtenerPrioridad(Long id) {
        return prioridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));
    }

    // Obtener prioridad por nivel
    public Optional<Prioridad> obtenerPrioridadPorNivel(int nivel) {
        return prioridadRepository.findByNivel(nivel);
    }

    public Prioridad actualizarPrioridad(Long id, Prioridad prioridad) {
        prioridad.setIdPrioridad(id);
        return prioridadRepository.save(prioridad);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

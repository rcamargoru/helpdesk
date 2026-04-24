/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jr.jr.helpDesk.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ricardo
 */
@Service
public class RestTemplateConfig {
    
      public RestTemplate restTemplate(String jwtToken) {
        RestTemplate restTemplate = new RestTemplate();

        // Interceptor para agregar el token JWT
        restTemplate.getInterceptors().add((HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
            request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
            return execution.execute(request, body);
        });

        return restTemplate;
    }  
}

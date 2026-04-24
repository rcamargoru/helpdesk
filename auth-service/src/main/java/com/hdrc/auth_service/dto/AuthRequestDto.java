/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.hdrc.auth_service.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Rc
 */
public record AuthRequestDto(@NotBlank String usuario,@NotBlank String clave ) {
}

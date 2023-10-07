package com.techjr.firstapi.dto;


import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.validation.constraints.Pattern;

@ControllerAdvice
public class UserUpdateDto {
    
    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "O nome deve conter apenas letras e ter no mínimo 2 caracteres")
    public String name;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "O email deve ser válido")
    public String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$", message = "A senha deve conter no mínimo 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

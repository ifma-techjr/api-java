package com.techjr.firstapi.dto;


import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@ControllerAdvice
public class UserDto {
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco")
    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "O nome deve conter apenas letras e ter no mínimo 2 caracteres")
    public String name;

    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode estar em branco")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "O email deve ser válido")
    public String email;

    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não pode estar em branco")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$", message = "A senha deve conter no mínimo 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    public String password;

    @NotNull(message = "O campo isAdmin não pode ser nulo")
    public boolean isAdmin;

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}

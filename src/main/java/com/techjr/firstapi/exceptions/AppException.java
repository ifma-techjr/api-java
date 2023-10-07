package com.techjr.firstapi.exceptions;

import org.springframework.http.HttpStatus;

public class AppException extends Exception{
    private String message;
    private HttpStatus status;

    public AppException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    // Getters & Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

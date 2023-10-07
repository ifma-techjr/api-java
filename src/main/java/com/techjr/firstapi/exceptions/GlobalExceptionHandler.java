package com.techjr.firstapi.exceptions;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({Exception.class})
    public ResponseEntity<HashMap<String, String>> handleInternal(){
        HashMap<String, String> retorno = new HashMap<>();
        retorno.put("message", "Erro interno do servidor.");

        return new ResponseEntity<HashMap<String,String>>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<HashMap<String, String>> handleAppException(AppException ex){
        HashMap<String, String> retorno = new HashMap<>();
        retorno.put("message", ex.getMessage());

        return new ResponseEntity<HashMap<String,String>>(retorno, ex.getStatus());
    }
}

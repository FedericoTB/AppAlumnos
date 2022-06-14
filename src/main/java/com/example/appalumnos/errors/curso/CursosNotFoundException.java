package com.example.appalumnos.errors.curso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CursosNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 3259834721206227853L;

    public CursosNotFoundException(String message) {
        super(message);
    }
}

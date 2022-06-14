package com.example.appalumnos.errors.modulo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModuloNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7720664731463624704L;

    public ModuloNotFoundException(String message) {
        super(message);
    }
}

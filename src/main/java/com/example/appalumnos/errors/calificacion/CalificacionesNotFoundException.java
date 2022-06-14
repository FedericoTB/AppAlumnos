package com.example.appalumnos.errors.calificacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CalificacionesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1379630857833853150L;

    public CalificacionesNotFoundException(String message) {
        super(message);
    }
}

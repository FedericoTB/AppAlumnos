package com.example.appalumnos.errors.alumno;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlumnosNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3024799110761355298L;

    public AlumnosNotFoundException(String message) {
        super(message);
    }
}

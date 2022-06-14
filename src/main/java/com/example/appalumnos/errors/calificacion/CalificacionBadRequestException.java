package com.example.appalumnos.errors.calificacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CalificacionBadRequestException extends RuntimeException {
    private static final long serialVersionUID = 3746305670398611505L;
    public CalificacionBadRequestException(String error, String message) {
        super("Existe un error en el campo: "+ error +" : "+ message);
    }
}

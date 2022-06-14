package com.example.appalumnos.errors.modulo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModulosNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 342564731610288772L;

    public ModulosNotFoundException() {
        super("Modulo list is empty or not exist");
    }
}

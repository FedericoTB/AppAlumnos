package com.example.appalumnos.errors.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StorageFileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -91556995685365130L;
    public StorageFileNotFoundException(String message) {
        super(message);
    }
    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
}

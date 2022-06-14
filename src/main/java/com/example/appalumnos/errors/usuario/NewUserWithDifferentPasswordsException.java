package com.example.appalumnos.errors.usuario;

public class NewUserWithDifferentPasswordsException extends RuntimeException {
    private static final long serialVersionUID = 1042248886670455080L;

    public NewUserWithDifferentPasswordsException() {
        super("Las contraseñas no coinciden");
    }

}

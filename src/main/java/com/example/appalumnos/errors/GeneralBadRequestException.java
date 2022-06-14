package com.example.appalumnos.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralBadRequestException extends RuntimeException {
    private static final long serialVersionUID = -3186650348251512693L;

    public GeneralBadRequestException(String operacion, String error) {
        super("Error al procesar: " + operacion + " : " + error);
    }
}

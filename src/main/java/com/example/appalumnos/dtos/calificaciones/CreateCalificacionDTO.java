package com.example.appalumnos.dtos.calificaciones;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCalificacionDTO {
    private Long alumno_id;
    private Long modulo_id;
    @Max(message = "El precio no puede ser mayor que 10", value = 10)
    @Min(message = "El precio no puede ser negativo", value = 0)
    private Double score;
}

package com.example.appalumnos.dtos.calificaciones;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionAlumnoDTO {
    private String modulo;
    private Double score;
}

package com.example.appalumnos.dtos.calificaciones;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionModuloDTO {
    private String alumno;
    private Double score;
}

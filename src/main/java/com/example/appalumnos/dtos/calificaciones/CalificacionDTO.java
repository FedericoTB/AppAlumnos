package com.example.appalumnos.dtos.calificaciones;

import com.example.appalumnos.dtos.alumnos.AlumnoDTO;
import com.example.appalumnos.dtos.modulos.ModuloDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionDTO {
    private Long id;
    @JsonBackReference
    private AlumnoDTO alumno;
    @JsonBackReference
    private ModuloDTO modulo;
    private Double score;
}

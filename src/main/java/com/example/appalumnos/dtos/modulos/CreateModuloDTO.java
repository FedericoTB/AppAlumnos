package com.example.appalumnos.dtos.modulos;

import com.example.appalumnos.dtos.calificaciones.CreateCalificacionDTO;
import lombok.*;


import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateModuloDTO {
    private String name;
    private String acronym;
    private Long curso_id;
    private Set<CreateCalificacionDTO> calificaciones;
}

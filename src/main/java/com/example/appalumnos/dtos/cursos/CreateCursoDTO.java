package com.example.appalumnos.dtos.cursos;

import com.example.appalumnos.dtos.modulos.CreateModuloDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCursoDTO {
    private String name;
    private String acronym;
    @JsonManagedReference
    private Set<CreateModuloDTO> modulos;
}

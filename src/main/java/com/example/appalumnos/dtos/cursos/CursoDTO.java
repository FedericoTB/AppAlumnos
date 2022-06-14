package com.example.appalumnos.dtos.cursos;

import com.example.appalumnos.dtos.modulos.ModuloDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String name;
    private String acronym;
    @JsonManagedReference
    private Set<ModuloDTO> modulos;
}

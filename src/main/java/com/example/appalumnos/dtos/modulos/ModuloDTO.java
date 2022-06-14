package com.example.appalumnos.dtos.modulos;

import com.example.appalumnos.dtos.calificaciones.CalificacionModuloDTO;
import com.example.appalumnos.dtos.cursos.CursoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuloDTO {
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotBlank(message = "El acronimo no puede estar vacío")
    private String acronym;
    private LocalDateTime createdAt;
    @JsonBackReference
    private CursoDTO curso;
    @JsonManagedReference
    private Set<CalificacionModuloDTO> calificaciones;
}

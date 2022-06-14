package com.example.appalumnos.dtos.alumnos;

import com.example.appalumnos.dtos.calificaciones.CalificacionAlumnoDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String imageAvatarUrl;
    private Set<CalificacionAlumnoDTO> calificaciones;
}

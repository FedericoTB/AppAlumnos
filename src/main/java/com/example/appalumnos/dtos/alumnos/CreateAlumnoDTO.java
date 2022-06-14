package com.example.appalumnos.dtos.alumnos;

import com.example.appalumnos.dtos.calificaciones.CreateCalificacionDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAlumnoDTO {
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String imageAvatarUrl;
    private Set<CreateCalificacionDTO> calificaciones;
}

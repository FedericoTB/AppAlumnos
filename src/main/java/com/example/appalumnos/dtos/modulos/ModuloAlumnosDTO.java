package com.example.appalumnos.dtos.modulos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuloAlumnosDTO {
    private String name;
    private List<String> alumnos;
}

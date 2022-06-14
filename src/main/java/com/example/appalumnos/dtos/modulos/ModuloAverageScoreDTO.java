package com.example.appalumnos.dtos.modulos;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuloAverageScoreDTO {
    private String name;
    private Double average;
}

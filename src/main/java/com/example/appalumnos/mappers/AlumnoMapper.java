package com.example.appalumnos.mappers;

import com.example.appalumnos.dtos.alumnos.AlumnoCompleteDTO;
import com.example.appalumnos.dtos.alumnos.AlumnoDTO;
import com.example.appalumnos.dtos.alumnos.CreateAlumnoDTO;
import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.repositories.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlumnoMapper {
    private final ModelMapper modelMapper;
    private final CalificacionMapper calificacionMapper;
    private final CursoRepository cursoRepository;

    @Autowired
    public AlumnoMapper(ModelMapper modelMapper, CalificacionMapper calificacionMapper, CursoRepository cursoRepository) {
        this.modelMapper = modelMapper;
        this.calificacionMapper = calificacionMapper;
        this.cursoRepository = cursoRepository;
    }
    public AlumnoDTO toDTO(Alumno alumno){
        return new AlumnoDTO(
                alumno.getId(),
                alumno.getName(),
                alumno.getEmail(),
                alumno.getCreatedAt(),
                alumno.getUpdatedAt(),
                alumno.getImageAvatarUrl(),
                calificacionMapper.toDTOAlumno(alumno.getCalificaciones())
        );
    }
    public List<AlumnoDTO> toDTO(List<Alumno> alumnos){
        return alumnos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Alumno fromCreateDTO(CreateAlumnoDTO alumnoDTO) {
        return new Alumno().builder()
                .name(alumnoDTO.getName())
                .email(alumnoDTO.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .imageAvatarUrl(alumnoDTO.getImageAvatarUrl())
                .calificaciones(calificacionMapper.fromCreateDTO(alumnoDTO.getCalificaciones()))
                .build();
    }

    public AlumnoCompleteDTO toCompleteDTO(Alumno alumno) {
        return new AlumnoCompleteDTO().builder()
                .id(alumno.getId())
                .name(alumno.getName())
                .email(alumno.getEmail())
                .createdAt(alumno.getCreatedAt())
                .updatedAt(alumno.getUpdatedAt())
                .calificaciones(calificacionMapper.toDTOAlumno(alumno.getCalificaciones()))
                .imageAvatarUrl(alumno.getImageAvatarUrl())
                .curso(alumno.getCalificaciones().stream().findAny().get().getModulo().getCurso().getName())
                .build();
    }
}

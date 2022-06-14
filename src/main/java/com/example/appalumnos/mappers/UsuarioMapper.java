package com.example.appalumnos.mappers;

import com.example.appalumnos.dtos.usuarios.GetUsuarioDTO;
import com.example.appalumnos.models.Rol;
import com.example.appalumnos.models.Usuario;
import com.example.appalumnos.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    private final AlumnoMapper alumnoMapper;
    private final AlumnoRepository alumnoRepository;
    @Autowired
    public UsuarioMapper(AlumnoMapper alumnoMapper, AlumnoRepository alumnoRepository) {
        this.alumnoMapper = alumnoMapper;
        this.alumnoRepository = alumnoRepository;
    }

    public GetUsuarioDTO toDTO(Usuario user) {
        return GetUsuarioDTO.builder()
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .alumno(alumnoMapper.toDTO(alumnoRepository.findById(user.getAlumno().getId()).get()))
                .roles(user.getRoles().stream()
                        .map(Rol::name)
                        .collect(Collectors.toSet())
                ).build();
    }
}


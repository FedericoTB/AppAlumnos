package com.example.appalumnos.mappers;

import com.example.appalumnos.dtos.cursos.CreateCursoDTO;
import com.example.appalumnos.dtos.cursos.CursoDTO;
import com.example.appalumnos.models.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CursoMapper {
    private final ModelMapper modelMapper;
    private final ModuloMapper moduloMapper;

    @Autowired
    public CursoMapper(ModelMapper modelMapper, ModuloMapper moduloMapper) {
        this.modelMapper = modelMapper;
        this.moduloMapper = moduloMapper;
    }

    public CursoDTO toDTO(Curso curso){
        Set<String> modulos = new HashSet<>();
        curso.getModulos().stream().forEach(m->modulos.add(m.getName()));
        return new CursoDTO(
                curso.getId(),
                curso.getName(),
                curso.getAcronym(),
                moduloMapper.toDTO(curso.getModulos()));

    }

    public Curso fromDTO(CursoDTO cursoDTO){
        return modelMapper.map(cursoDTO, Curso.class);
    }

    public List<CursoDTO> toDTO(List<Curso> cursos){
        return cursos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Curso fromDTO(CreateCursoDTO cursoDTO) {
        return new Curso().builder()
                .name(cursoDTO.getName())
                .acronym(cursoDTO.getName())
                .createdAt(LocalDateTime.now())
                .modulos(moduloMapper.fromCreateDTO(cursoDTO.getModulos()))
                .build();
    }
}

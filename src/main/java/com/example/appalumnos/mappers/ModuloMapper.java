package com.example.appalumnos.mappers;

import com.example.appalumnos.dtos.cursos.CursoDTO;
import com.example.appalumnos.dtos.modulos.CreateModuloDTO;
import com.example.appalumnos.dtos.modulos.ModuloAverageScoreDTO;
import com.example.appalumnos.dtos.modulos.ModuloDTO;
import com.example.appalumnos.models.Calificacion;
import com.example.appalumnos.models.Curso;
import com.example.appalumnos.models.Modulo;
import com.example.appalumnos.repositories.CalificacionRepository;
import com.example.appalumnos.repositories.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ModuloMapper {
    private final ModelMapper modelMapper;
    private final CalificacionMapper calificacionMapper;
    private final CalificacionRepository calificacionRepository;
    private final CursoRepository cursoRepository;
    @Autowired
    public ModuloMapper(ModelMapper modelMapper, CalificacionMapper calificacionMapper, CalificacionRepository calificacionRepository, CursoRepository cursoRepository) {
        this.modelMapper = modelMapper;
        this.calificacionMapper = calificacionMapper;
        this.calificacionRepository = calificacionRepository;
        this.cursoRepository = cursoRepository;
    }

    public ModuloDTO toDTO(Modulo modulo){
       return new ModuloDTO(
                modulo.getId(),
                modulo.getName(),
                modulo.getAcronym(),
                modulo.getCreatedAt(),
                modelMapper.map(modulo.getCurso(), CursoDTO.class),
               calificacionMapper.toDTOModulo(modulo.getCalificaciones())
                );
    }

    public ModuloAverageScoreDTO toAverageScoreDTO(Modulo modulo) {
        return new ModuloAverageScoreDTO(modulo.getName(),
                modulo.getCalificaciones().stream().mapToDouble(Calificacion::getScore).average().getAsDouble()
        );
    }

    public Modulo fromDTO(ModuloDTO moduloDTO){
        return new Modulo(
                moduloDTO.getId(),
                moduloDTO.getName(),
                moduloDTO.getAcronym(),
                moduloDTO.getCreatedAt(),
                modelMapper.map(moduloDTO.getCurso(), Curso.class),
                calificacionRepository.findAllByModulo_Id(moduloDTO.getId())
        );
    }

    public Modulo fromCreateDTO(CreateModuloDTO moduloDTO) {
        return  new Modulo().builder()
                .name(moduloDTO.getName())
                .acronym( moduloDTO.getAcronym())
                .createdAt(LocalDateTime.now())
                .curso(cursoRepository.findById(moduloDTO.getCurso_id()).get())
                .calificaciones(calificacionMapper.fromCreateDTO(moduloDTO.getCalificaciones()))
                .build();
    }

    public List<ModuloDTO> toDTO(List<Modulo> moduloList){
        return moduloList.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public Set<ModuloDTO> toDTO(Set<Modulo> modulos){
        return modulos.stream().map(this::toDTO).collect(Collectors.toSet());
    }
    public Set<Modulo> fromCreateDTO(Set<CreateModuloDTO> modulos) {
        return modulos.stream().map(this::fromCreateDTO).collect(Collectors.toSet());
    }


}

package com.example.appalumnos.mappers;

import com.example.appalumnos.dtos.alumnos.AlumnoDTO;
import com.example.appalumnos.dtos.calificaciones.CalificacionAlumnoDTO;
import com.example.appalumnos.dtos.calificaciones.CalificacionDTO;
import com.example.appalumnos.dtos.calificaciones.CalificacionModuloDTO;
import com.example.appalumnos.dtos.calificaciones.CreateCalificacionDTO;
import com.example.appalumnos.dtos.modulos.ModuloDTO;
import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.models.Calificacion;
import com.example.appalumnos.models.Modulo;
import com.example.appalumnos.repositories.AlumnoRepository;
import com.example.appalumnos.repositories.CalificacionRepository;
import com.example.appalumnos.repositories.ModuloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.cert.CertPathBuilder;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CalificacionMapper {
   private final ModelMapper modelMapper;
   private final CalificacionRepository calificacionRepository;
   private final AlumnoRepository alumnoRepository;
   private final ModuloRepository moduloRepository;

   @Autowired
    public CalificacionMapper(ModelMapper modelMapper, CalificacionRepository calificacionRepository, AlumnoRepository alumnoRepository, ModuloRepository moduloRepository) {
        this.modelMapper = modelMapper;
        this.calificacionRepository = calificacionRepository;
        this.alumnoRepository = alumnoRepository;
        this.moduloRepository = moduloRepository;
    }

    public CalificacionDTO toDTO(Calificacion calificacion){
        return new CalificacionDTO(
                calificacion.getId(),
                modelMapper.map(calificacion.getAlumno(), AlumnoDTO.class),
                modelMapper.map(calificacion.getModulo(), ModuloDTO.class),
                calificacion.getScore());
    }

    public CalificacionAlumnoDTO toDTOAlumno(Calificacion calificacion){
        return new CalificacionAlumnoDTO(
                calificacion.getModulo().getName(),
                calificacion.getScore()
        );
    }

    public CalificacionModuloDTO toDTOModulo(Calificacion calificacion){
        return new CalificacionModuloDTO(
                calificacion.getAlumno().getName(),
                calificacion.getScore()
        );
    }

    public Calificacion fromDTO(CalificacionDTO calificacionDTO){
        return new Calificacion(
                calificacionDTO.getId(),
                modelMapper.map(calificacionDTO.getAlumno(), Alumno.class),
                modelMapper.map(calificacionDTO.getModulo(), Modulo.class),
                calificacionDTO.getScore()
        );
    }

    public Calificacion fromCreateDTO(CreateCalificacionDTO calificacionDTO) {
        Calificacion calificacion = new Calificacion();
        calificacion.setAlumno(alumnoRepository.findById(calificacionDTO.getAlumno_id()).get());
        calificacion.setModulo(moduloRepository.findById(calificacionDTO.getModulo_id()).get());
        calificacion.setScore(calificacionDTO.getScore());
        return calificacion;
    }

    public Set<CalificacionDTO> toDTO(Set<Calificacion> calificaciones){
        return calificaciones.stream().map(this::toDTO).collect(Collectors.toSet());
    }

    public List<CalificacionDTO> toDTO(List<Calificacion> calificacionList) {
        return calificacionList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Set<CalificacionAlumnoDTO> toDTOAlumno(Set<Calificacion> calificaciones){
        return calificaciones.stream().map(this::toDTOAlumno).collect(Collectors.toSet());
    }
    public Set<CalificacionModuloDTO> toDTOModulo(Set<Calificacion> calificaciones){
        return calificaciones.stream().map(this::toDTOModulo).collect(Collectors.toSet());
    }

    public Set<Calificacion> fromDTO(Set<CalificacionDTO> calificaciones) {
        return calificaciones.stream().map(this::fromDTO).collect(Collectors.toSet());
    }

    public Set<Calificacion> fromCreateDTO(Set<CreateCalificacionDTO> calificaciones) {
        return calificaciones.stream().map(this::fromCreateDTO).collect(Collectors.toSet());
    }


}

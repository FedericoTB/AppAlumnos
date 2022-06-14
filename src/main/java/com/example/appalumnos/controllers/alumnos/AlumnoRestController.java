package com.example.appalumnos.controllers.alumnos;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.dtos.alumnos.AlumnoCompleteDTO;
import com.example.appalumnos.dtos.alumnos.AlumnoDTO;
import com.example.appalumnos.dtos.alumnos.CreateAlumnoDTO;
import com.example.appalumnos.dtos.alumnos.ListAlumnoPageDTO;
import com.example.appalumnos.errors.GeneralBadRequestException;
import com.example.appalumnos.errors.alumno.AlumnosNotFoundException;
import com.example.appalumnos.mappers.AlumnoMapper;
import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(APIConfig.API_PATH +"/alumnos")
public class AlumnoRestController {
    private final AlumnoMapper alumnoMapper;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoRestController(AlumnoMapper alumnoMapper, AlumnoRepository alumnoRepository) {
        this.alumnoMapper = alumnoMapper;
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Test Alumno. all OK";
    }

    @GetMapping("/")
    public ResponseEntity<List<AlumnoDTO>> findAll(){
        List<Alumno> alumnoList = null;
        alumnoList = alumnoRepository.findAll();
        if(!alumnoList.isEmpty()){
            return ResponseEntity.ok(alumnoMapper.toDTO(alumnoList));
        }else{
            throw new AlumnosNotFoundException("Error al buscar todos los alumnos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> findById(@PathVariable Long id){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if(alumno == null){
            throw new AlumnosNotFoundException("No se pudo encontrar Alumno con ID: "+id);
        }else{
            return ResponseEntity.ok(alumnoMapper.toDTO(alumno));
        }
    }
    @GetMapping("/complete/{id}")
    public ResponseEntity<AlumnoCompleteDTO> findCompleteById(@PathVariable Long id){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if(alumno == null){
            throw new AlumnosNotFoundException("No se pudo encontrar Alumno con ID: "+id);
        }else{
            return ResponseEntity.ok(alumnoMapper.toCompleteDTO(alumno));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllPageable(
            @RequestParam(required = false, name = "name")Optional<String> name,
            @RequestParam(required = false, name = "email")Optional<String> email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
            ){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,sort);
        Page<Alumno> pagedResult;
        try{
            if(name.isPresent()&&email.isPresent()){
                pagedResult = alumnoRepository.findAllByNameContainsIgnoreCaseAndEmailContainsIgnoreCase(name.get(),email.get(),pageable);
            } else if (name.isPresent()){
                pagedResult = alumnoRepository.findAllByNameContainsIgnoreCase(name.get(),pageable);
            } else if (email.isPresent()){
                pagedResult = alumnoRepository.findAllByEmailContainsIgnoreCase(email.get(),pageable);
            } else{
                pagedResult = alumnoRepository.findAll(pageable);
            }
            ListAlumnoPageDTO alumnoPageDTO = ListAlumnoPageDTO.builder()
                    .data(alumnoMapper.toDTO(pagedResult.getContent()))
                    .totalPages(pagedResult.getTotalPages())
                    .totalElements(pagedResult.getTotalElements())
                    .currentPage(pagedResult.getNumber())
                    .sort(pagedResult.getSort().toString())
                    .build();
            return ResponseEntity.ok(alumnoPageDTO);
        }catch(Exception e){
            throw new GeneralBadRequestException("Seleccion de datos","Parametros de busqueda de alumnos incorrectos: "+e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<AlumnoDTO> save(@RequestBody CreateAlumnoDTO alumnoDTO){
        Alumno alumno = alumnoMapper.fromCreateDTO(alumnoDTO);
        try{
            Alumno alumnoInserted = alumnoRepository.save(alumno);
            return ResponseEntity.ok(alumnoMapper.toDTO(alumno));
        } catch (Exception e){
            throw new GeneralBadRequestException("Insertar", "Error al intentar insertar alumno : "+e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno){
        Alumno alumnoUpdated = alumnoRepository.findById(id).orElse(null);
        if(alumnoUpdated == null){
            throw new AlumnosNotFoundException("No se pudo encontrar Alumno para Actualizar con ID: "+id);
        }
        alumnoUpdated.setName(alumno.getName());
        alumnoUpdated.setEmail(alumno.getEmail());
        alumnoUpdated.setCreatedAt(alumno.getCreatedAt());
        alumnoUpdated.setUpdatedAt(LocalDateTime.now());
        alumnoUpdated.setImageAvatarUrl(alumno.getImageAvatarUrl());
        alumnoUpdated.setCalificaciones(alumno.getCalificaciones());
        try{
            alumnoUpdated = alumnoRepository.save(alumnoUpdated);
            return ResponseEntity.ok(alumnoMapper.toDTO(alumnoUpdated));
        } catch (Exception e){
            throw new GeneralBadRequestException("Actualizar","Error al intentar actualizar Alumno con ID: "+id+" : "+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDTO> delete(@PathVariable Long id){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if(alumno == null) {
            throw new AlumnosNotFoundException("No se pudo encontrar Alumno para eliminar con ID: " + id);
        }
        try{
            alumnoRepository.delete(alumno);
            return ResponseEntity.ok(alumnoMapper.toDTO(alumno));
        }catch(Exception e){
            throw new GeneralBadRequestException("Eliminar","Error al intentar eliminar Alumno con ID: "+id+" : "+e.getMessage());
        }
    }
}

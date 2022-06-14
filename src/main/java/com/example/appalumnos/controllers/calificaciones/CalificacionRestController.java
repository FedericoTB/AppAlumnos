package com.example.appalumnos.controllers.calificaciones;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.dtos.calificaciones.CalificacionDTO;
import com.example.appalumnos.dtos.calificaciones.CreateCalificacionDTO;
import com.example.appalumnos.dtos.calificaciones.ListCalificacionPageDTO;
import com.example.appalumnos.errors.GeneralBadRequestException;
import com.example.appalumnos.errors.calificacion.CalificacionBadRequestException;
import com.example.appalumnos.errors.calificacion.CalificacionesNotFoundException;
import com.example.appalumnos.mappers.CalificacionMapper;
import com.example.appalumnos.models.Calificacion;
import com.example.appalumnos.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(APIConfig.API_PATH +"/calificaciones")
public class CalificacionRestController {
    private final CalificacionMapper calificacionMapper;
    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionRestController(CalificacionMapper calificacionMapper, CalificacionRepository calificacionRepository) {
        this.calificacionMapper = calificacionMapper;
        this.calificacionRepository = calificacionRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Test Calificacion. all OK";
    }

    @GetMapping("/")
    public ResponseEntity<List<CalificacionDTO>> findAll(){
        List<Calificacion> calificacionList = null;
        calificacionList = calificacionRepository.findAll();
        if(!calificacionList.isEmpty()){
            return ResponseEntity.ok(calificacionMapper.toDTO(calificacionList));
        } else{
            throw new CalificacionesNotFoundException("Error al buscar todas las calificaciones");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDTO> findById(@PathVariable Long id){
        Calificacion calificacion = calificacionRepository.findById(id).orElse(null);
        if(calificacion == null){
            throw new CalificacionesNotFoundException("No se pudo encontrar calificacion con ID: "+id);
        }else {
            return ResponseEntity.ok(calificacionMapper.toDTO(calificacion));
        }
    }

    @PostMapping("/")
    public ResponseEntity<CalificacionDTO> save(@RequestBody CreateCalificacionDTO calificacionDTO){
        Calificacion calificacion = calificacionMapper.fromCreateDTO(calificacionDTO);
        checkCalificacion(calificacion);
        try{
            Calificacion calificacionInserted = calificacionRepository.save(calificacion);
            return ResponseEntity.ok(calificacionMapper.toDTO(calificacion));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new GeneralBadRequestException("Insert","Error al intentar insertar Calificion: "+e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalificacionDTO> update(@PathVariable Long id, @RequestBody Calificacion calificacion){
        Calificacion calificacionUpdated = calificacionRepository.findById(id).orElse(null);
        if( calificacionUpdated == null){
            throw new CalificacionesNotFoundException("No se pudo encontrar Calificacion para actualizar con ID: "+id);
        }
        checkCalificacion(calificacion);
        calificacionUpdated.setAlumno(calificacion.getAlumno());
        calificacionUpdated.setModulo(calificacion.getModulo());
        calificacionUpdated.setScore(calificacion.getScore());
        try{
            calificacionUpdated = calificacionRepository.save(calificacionUpdated);
            return ResponseEntity.ok(calificacionMapper.toDTO(calificacionUpdated));
        }catch (Exception e){
            throw new GeneralBadRequestException("Actualizar","Error al actualizar califacion. Campos incorrectos: "+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CalificacionDTO> delete(@PathVariable Long id){
        Calificacion calificacion = calificacionRepository.findById(id).orElse(null);
        if(calificacion == null){
            throw new CalificacionesNotFoundException("No se pudo encontrar Calificacion para eliminar con ID: "+id);
        }
        try{
            calificacionRepository.delete(calificacion);
            return ResponseEntity.ok(calificacionMapper.toDTO(calificacion));
        }catch (Exception e){
            throw new GeneralBadRequestException("Eliminar","Error al intentar eliminar calificacion: "+e.getMessage());
        }
    }
    private void checkCalificacion(Calificacion calificacion) {
        System.out.println(calificacion.getId()+" " +
                calificacion.getAlumno().getId()+" "+
                calificacion.getModulo().getId()+" "+
                calificacion.getScore());
        if(calificacion.getScore()>10){
            throw new CalificacionBadRequestException("Score","debe ser menor de 10");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPageable(
            @RequestParam(required= false, name= "alumno_id") Optional<Long> alumnoId,
            @RequestParam(required= false, name= "modulo_id") Optional<Long> moduloId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,sort);
        Page<Calificacion> pagedResult;
        try {
            if(alumnoId.isPresent() && moduloId.isPresent()){
                pagedResult = calificacionRepository.findAllByAlumno_IdAndModulo_Id(alumnoId.get(),moduloId.get(),pageable);
            }else if(alumnoId.isPresent()){
                pagedResult = calificacionRepository.findAllByAlumno_Id(alumnoId.get(),pageable);
            }else if(moduloId.isPresent()){
                pagedResult = calificacionRepository.findAllByModulo_Id(moduloId.get(),pageable);
            }else{
                pagedResult = calificacionRepository.findAll(pageable);
            }
            ListCalificacionPageDTO calificacionPageDTO = ListCalificacionPageDTO.builder()
                    .data(calificacionMapper.toDTO(pagedResult.getContent()))
                    .totalPages(pagedResult.getTotalPages())
                    .totalElements(pagedResult.getTotalElements())
                    .currentPage(pagedResult.getNumber())
                    .sort(pagedResult.getSort().toString())
                    .build();
            return ResponseEntity.ok(calificacionPageDTO);
        } catch (Exception e) {
            throw new GeneralBadRequestException("Selección de Datos", "Parámetros de consulta de Califaciones incorrectos");
        }

    }
}

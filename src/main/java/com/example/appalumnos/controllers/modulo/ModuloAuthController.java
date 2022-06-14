package com.example.appalumnos.controllers.modulo;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.dtos.modulos.*;
import com.example.appalumnos.errors.GeneralBadRequestException;
import com.example.appalumnos.errors.modulo.ModuloNotFoundException;
import com.example.appalumnos.errors.modulo.ModulosNotFoundException;
import com.example.appalumnos.mappers.ModuloMapper;
import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.models.Modulo;
import com.example.appalumnos.repositories.AlumnoRepository;
import com.example.appalumnos.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIConfig.API_PATH+"/auth/modulos")
public class ModuloAuthController {
    private final ModuloRepository moduloRepository;
    private final ModuloMapper moduloMapper;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public ModuloAuthController(ModuloRepository moduloRepository, ModuloMapper moduloMapper, AlumnoRepository alumnoRepository) {
        this.moduloRepository = moduloRepository;
        this.moduloMapper = moduloMapper;
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "Test Modulo. all OK";
    }

    @GetMapping("/")
    public ResponseEntity<List<ModuloDTO>> findAll(){
        List<Modulo> moduloList = null;
        moduloList = moduloRepository.findAll();
        if(!moduloList.isEmpty()){
            return ResponseEntity.ok(moduloMapper.toDTO(moduloList));
        }else{
            throw new ModulosNotFoundException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloDTO> findById(@PathVariable Long id){
        Modulo modulo = moduloRepository.findById(id).orElse(null);
        if (modulo == null){
            throw new ModuloNotFoundException("No se pudo encontrar Modulo con ID: "+id);
        }else{
            return  ResponseEntity.ok(moduloMapper.toDTO(modulo));
        }
    }

    @GetMapping("/average/{id}")
    public ResponseEntity<ModuloAverageScoreDTO> averageScoreById(@PathVariable Long id){
        Modulo modulo = moduloRepository.findById(id).orElse(null);
        if (modulo == null){
            throw new ModuloNotFoundException("No se pudo encontrar Modulo con ID: "+id);
        }else{
            return  ResponseEntity.ok(moduloMapper.toAverageScoreDTO(modulo));
        }
    }
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<ModuloAlumnosDTO> findModuloAlumnosById(@PathVariable Long id){
        Modulo modulo = moduloRepository.findById(id).orElse(null);

        if(modulo == null){
            throw new ModuloNotFoundException("No se pudo encontrar Modulo con ID: "+id);
        }else{
            List<Alumno> alumnoList = alumnoRepository.findAlumnosByCalificaciones_Modulo_id(modulo.getId());
            ModuloAlumnosDTO moduloDto = new ModuloAlumnosDTO().builder()
                    .name(modulo.getName())
                    .alumnos(alumnoList.stream().map(Alumno::getName).collect(Collectors.toList()))
                    .build();
            return ResponseEntity.ok(moduloDto);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllPageable(
            @RequestParam(required = false,name = "name") Optional<String> name,
            @RequestParam(required = false,name = "acronym") Optional<String> acronym,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,sort);
        Page<Modulo> pagedResult;
        try{
            if(name.isPresent() && acronym.isPresent()){
                pagedResult = moduloRepository.findAllByNameContainsIgnoreCaseAndAcronymContainsIgnoreCase(name.get(),acronym.get(),pageable);
            }else if(name.isPresent()){
                pagedResult = moduloRepository.findAllByNameContainsIgnoreCase(name.get(),pageable);
            }else if(acronym.isPresent()){
                pagedResult = moduloRepository.findAllByAcronymContainsIgnoreCase(acronym.get(),pageable);
            }else{
                pagedResult = moduloRepository.findAll(pageable);
            }
            ListModuloPageDTO moduloPageDTO = ListModuloPageDTO.builder()
                    .data(moduloMapper.toDTO(pagedResult.getContent()))
                    .totalPages(pagedResult.getTotalPages())
                    .totalElements(pagedResult.getTotalElements())
                    .currentPage(pagedResult.getNumber())
                    .sort(pagedResult.getSort().toString())
                    .build();
            return ResponseEntity.ok(moduloPageDTO);
        } catch (Exception e){
            throw new GeneralBadRequestException("Seleccion de Datos","Parámetros de consulta de Modulos incorrectos");
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModuloDTO> save(@RequestBody CreateModuloDTO moduloDTO){
        Modulo modulo = moduloMapper.fromCreateDTO(moduloDTO);
        try{
            Modulo moduloInserted = moduloRepository.save(modulo);
            return ResponseEntity.ok(moduloMapper.toDTO(moduloInserted));
        }catch (Exception e){
            throw new GeneralBadRequestException("Insertar","Error al intentar insertar un Modulo : "+e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloDTO> update(@PathVariable Long id, @RequestBody Modulo modulo){
        Modulo moduloUpdated = moduloRepository.findById(id).orElse(null);
        if(moduloUpdated==null){
            throw new ModuloNotFoundException("No se pudo encontrar Modulo para actualizar con ID: "+id);
        }
        moduloUpdated.setName(modulo.getName());
        moduloUpdated.setAcronym(modulo.getAcronym());
        moduloUpdated.setCurso(modulo.getCurso());
        moduloUpdated.setCalificaciones(modulo.getCalificaciones());
        try{
            moduloUpdated = moduloRepository.save(moduloUpdated);
            return ResponseEntity.ok(moduloMapper.toDTO(moduloUpdated));
        }catch (Exception e){
            throw new GeneralBadRequestException("Actualizar","Error al intentar actualizar Modulo con ID: "+id+" : "+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModuloDTO> delete(@PathVariable Long id){
        Modulo modulo = moduloRepository.findById(id).orElse(null);
        if (modulo == null) {
            throw new ModuloNotFoundException("No se pudo encontrar Modulo a actualizar con ID: "+id);
        }
        try{
            moduloRepository.delete(modulo);
            return ResponseEntity.ok(moduloMapper.toDTO(modulo));
        }catch (Exception e){
            throw new GeneralBadRequestException("Eliminar","Error al intentar eliminar Modulo con ID: "+id+" : "+e.getMessage());
        }
    }
}

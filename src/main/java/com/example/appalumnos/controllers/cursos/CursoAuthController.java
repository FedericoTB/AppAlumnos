package com.example.appalumnos.controllers.cursos;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.dtos.cursos.CreateCursoDTO;
import com.example.appalumnos.dtos.cursos.CursoDTO;
import com.example.appalumnos.dtos.cursos.ListCursoPageDTO;
import com.example.appalumnos.errors.GeneralBadRequestException;
import com.example.appalumnos.errors.curso.CursosNotFoundException;
import com.example.appalumnos.mappers.CursoMapper;
import com.example.appalumnos.models.Curso;
import com.example.appalumnos.repositories.CursoRepository;
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
@RequestMapping(APIConfig.API_PATH +"/auth/cursos")
public class CursoAuthController {
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    @Autowired
    public CursoAuthController(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @GetMapping("/test")
    public String test() {
        return "Test Curso. all OK";
    }

    @GetMapping("/")
    public ResponseEntity<List<CursoDTO>> findAll(){
        List<Curso> cursoList = null;
        cursoList = cursoRepository.findAll();
        if(!cursoList.isEmpty()){
            return ResponseEntity.ok(cursoMapper.toDTO(cursoList));
        }else{
            throw new CursosNotFoundException("Error al buscar todos los Cursos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable Long id){
        Curso curso = cursoRepository.findById(id).orElse(null);
        if(curso == null){
            throw new CursosNotFoundException("No se pudo encontrar Curso con ID: "+id);
        }else{
            return ResponseEntity.ok(cursoMapper.toDTO(curso));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPageable(
            @RequestParam(required = false, name="name") Optional<String> name,
            @RequestParam(required = false, name="acronym") Optional<String> acronym,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sort
    ){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,sort);
        Page<Curso> pageResult;
        try{
            if(name.isPresent() && acronym.isPresent()){
                pageResult = cursoRepository.findAllByNameContainsIgnoreCaseAndAcronymContainsIgnoreCase(name.get(),acronym.get(),pageable);
            } else if(name.isPresent()){
                pageResult = cursoRepository.findAllByNameContainsIgnoreCase(name.get(),pageable);
            } else if(acronym.isPresent()){
                pageResult = cursoRepository.findAllByAcronymContainsIgnoreCase(acronym.get(),pageable);
            }else{
                pageResult = cursoRepository.findAll(pageable);
            }
            ListCursoPageDTO cursoPageDTO = ListCursoPageDTO.builder()
                    .data(cursoMapper.toDTO(pageResult.getContent()))
                    .totalPages(pageResult.getTotalPages())
                    .totalElements(pageResult.getTotalElements())
                    .currentPage(pageResult.getNumber())
                    .sort(pageResult.getSort().toString())
                    .build();
            return ResponseEntity.ok(cursoPageDTO);
        } catch (Exception e) {
            throw new GeneralBadRequestException("Seleccion de datos","Paramentros de consulta incorrectos");
        }
    }

    @PostMapping("/")
    public ResponseEntity<CursoDTO> save(@RequestBody CreateCursoDTO cursoDTO){
        Curso curso = cursoMapper.fromDTO(cursoDTO);
        try{
            Curso cursoInserted = cursoRepository.save(curso);
            return ResponseEntity.ok(cursoMapper.toDTO(cursoInserted));
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new GeneralBadRequestException("Insert","Error al intentar insertar curso "+e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable Long id,@RequestBody Curso curso){
        Curso cursoUpdated = cursoRepository.findById(id).orElse(null);
        if(cursoUpdated == null){
            throw new CursosNotFoundException("No se pudo encontrar el Curso con ID: "+id);
        }
        cursoUpdated.setName(curso.getName());
        cursoUpdated.setAcronym(curso.getAcronym());
        try{
            cursoUpdated = cursoRepository.save(curso);
            return ResponseEntity.ok(cursoMapper.toDTO(cursoUpdated));
        }catch (Exception e){
            throw new GeneralBadRequestException("Actualizar","Error al intentar actualizar Curso con id"+id+" : "+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursoDTO> delete(@PathVariable Long id){
        Curso curso = cursoRepository.findById(id).orElse(null);
        if(curso == null){
            throw new CursosNotFoundException("No se pudo encontrar Curso para eliminar con ID: "+id);
        }
        try{
            cursoRepository.delete(curso);
            return ResponseEntity.ok(cursoMapper.toDTO(curso));
        }catch(Exception e){
            throw new GeneralBadRequestException("Eliminar","Error al intentar eliminar Curso con ID: "+id+" : "+e.getMessage());
        }
    }
}

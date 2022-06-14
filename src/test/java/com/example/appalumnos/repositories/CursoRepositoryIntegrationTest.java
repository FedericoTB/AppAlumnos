package com.example.appalumnos.repositories;


import com.example.appalumnos.models.Curso;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Levanto la BBDD en cada test
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CursoRepositoryIntegrationTest {
    private final Curso curso = new Curso().builder()
            .name("Curso para test")
            .acronym("CPT")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .build();
    @Autowired
    private CursoRepository cursoRepository;

    @Test
    @Order(1)
    void save(){
        Curso cursoSaved = cursoRepository.save(curso);
        assertAll(
                ()-> assertEquals(curso.getId(),cursoSaved.getId()),
                ()-> assertEquals(curso.getName(),cursoSaved.getName()),
                ()-> assertEquals(curso.getAcronym(),cursoSaved.getAcronym()),
                ()-> assertEquals(curso.getCreatedAt(),cursoSaved.getCreatedAt())
        );
    }

    @Test
    @Order(2)
    void findById(){
        Curso cursoSaved = cursoRepository.save(curso);
        Curso cursoFounded = cursoRepository.findById(cursoSaved.getId()).get();
        assertAll(
                ()-> assertEquals(cursoSaved.getId(),cursoFounded.getId()),
                ()-> assertEquals(cursoSaved.getName(),cursoFounded.getName()),
                ()-> assertEquals(cursoSaved.getAcronym(),cursoFounded.getAcronym()),
                ()-> assertEquals(cursoSaved.getCreatedAt(),cursoFounded.getCreatedAt())
        );
    }

    @Test
    @Order(3)
    void findAll(){
        Curso cursoSaved = cursoRepository.save(curso);
        List<Curso> cursosFounded = cursoRepository.findAll();
        assertAll(
                ()-> assertEquals(cursoSaved.getId(),cursosFounded.get(cursosFounded.size()-1).getId()),
                ()-> assertEquals(cursoSaved.getName(),cursosFounded.get(cursosFounded.size()-1).getName()),
                ()-> assertEquals(cursoSaved.getAcronym(),cursosFounded.get(cursosFounded.size()-1).getAcronym()),
                ()-> assertEquals(cursoSaved.getCreatedAt(),cursosFounded.get(cursosFounded.size()-1).getCreatedAt())
        );
    }

    @Test
    @Order(4)
    void update(){
        Curso cursoSaved = cursoRepository.save(curso);
        Curso cursoFounded = cursoRepository.findById(cursoSaved.getId()).get();
        cursoFounded.setName("Name in Test Changed");
        Curso cursoUpdated = cursoRepository.save(cursoFounded);

        assertAll(
                ()-> assertEquals(cursoFounded.getId(),cursoUpdated.getId()),
                ()-> assertEquals(cursoFounded.getName(),cursoUpdated.getName()),
                ()-> assertEquals(cursoFounded.getAcronym(),cursoUpdated.getAcronym()),
                ()-> assertEquals(cursoFounded.getCreatedAt(),cursoUpdated.getCreatedAt())
        );
    }

    @Test
    @Order(5)
    void delete(){
        Curso cursoSaved = cursoRepository.save(curso);
        cursoRepository.delete(curso);
        Curso cursoFounded = cursoRepository.findById(curso.getId()).orElse(null);
        assertNull(cursoFounded);
    }
}

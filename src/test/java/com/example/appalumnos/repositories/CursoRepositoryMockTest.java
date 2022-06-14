package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Curso;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CursoRepositoryMockTest {
    private final Curso curso = new Curso().builder()
            .name("Curso para test")
            .acronym("CPT")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .build();
    @MockBean
    private CursoRepository cursoRepository;

    @Test
    @Order(1)
    void save(){
        Mockito.when(cursoRepository.save(curso)).thenReturn(curso);
        Curso cursoSaved = cursoRepository.save(curso);
        assertAll(
                ()-> assertEquals(curso.getId(),cursoSaved.getId()),
                ()-> assertEquals(curso.getName(),cursoSaved.getName()),
                ()-> assertEquals(curso.getAcronym(),cursoSaved.getAcronym()),
                ()-> assertEquals(curso.getCreatedAt(),cursoSaved.getCreatedAt())
        );
        Mockito.verify(cursoRepository,Mockito.times(1)).save(curso);
    }

    @Test
    @Order(2)
    void findById(){
        Mockito.when(cursoRepository.save(curso)).thenReturn(curso);
        Curso cursoSaved = cursoRepository.save(curso);
        Mockito.when(cursoRepository.findById(cursoSaved.getId())).thenReturn(Optional.of(curso));
        Curso cursoFounded = cursoRepository.findById(cursoSaved.getId()).get();
        assertAll(
                ()-> assertEquals(cursoSaved.getId(),cursoFounded.getId()),
                ()-> assertEquals(cursoSaved.getName(),cursoFounded.getName()),
                ()-> assertEquals(cursoSaved.getAcronym(),cursoFounded.getAcronym()),
                ()-> assertEquals(cursoSaved.getCreatedAt(),cursoFounded.getCreatedAt())
        );
        Mockito.verify(cursoRepository,Mockito.times(1)).save(curso);
        Mockito.verify(cursoRepository,Mockito.times(1)).findById(cursoSaved.getId());
    }

    @Test
    @Order(3)
    void findAll(){
        Mockito.when(cursoRepository.save(curso)).thenReturn(curso);
        Curso cursoSaved = cursoRepository.save(curso);
        Mockito.when(cursoRepository.findAll()).thenReturn(List.of(curso));
        List<Curso> cursosFounded = cursoRepository.findAll();
        assertAll(
                ()-> assertEquals(cursoSaved.getId(),cursosFounded.get(cursosFounded.size()-1).getId()),
                ()-> assertEquals(cursoSaved.getName(),cursosFounded.get(cursosFounded.size()-1).getName()),
                ()-> assertEquals(cursoSaved.getAcronym(),cursosFounded.get(cursosFounded.size()-1).getAcronym()),
                ()-> assertEquals(cursoSaved.getCreatedAt(),cursosFounded.get(cursosFounded.size()-1).getCreatedAt())
        );
        Mockito.verify(cursoRepository,Mockito.times(1)).save(curso);
        Mockito.verify(cursoRepository,Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    void update(){
        Mockito.when(cursoRepository.save(curso)).thenReturn(curso);
        Curso cursoSaved = cursoRepository.save(curso);
        Mockito.when(cursoRepository.findById(cursoSaved.getId())).thenReturn(Optional.of(curso));
        Curso cursoFounded = cursoRepository.findById(cursoSaved.getId()).get();
        cursoFounded.setName("Name in Test Changed");
        Mockito.when(cursoRepository.save(cursoFounded)).thenReturn(cursoFounded);
        Curso cursoUpdated = cursoRepository.save(cursoFounded);

        assertAll(
                ()-> assertEquals(cursoFounded.getId(),cursoUpdated.getId()),
                ()-> assertEquals(cursoFounded.getName(),cursoUpdated.getName()),
                ()-> assertEquals(cursoFounded.getAcronym(),cursoUpdated.getAcronym()),
                ()-> assertEquals(cursoFounded.getCreatedAt(),cursoUpdated.getCreatedAt())
        );
        Mockito.verify(cursoRepository,Mockito.times(2)).save(curso);
        Mockito.verify(cursoRepository,Mockito.times(1)).findById(cursoSaved.getId());
    }

    @Test
    @Order(5)
    void delete(){
        Mockito.when(cursoRepository.save(curso)).thenReturn(curso);
        Curso cursoSaved = cursoRepository.save(curso);
        Mockito.doNothing().when(cursoRepository).delete(curso);
        cursoRepository.delete(curso);
        Mockito.when(cursoRepository.findById(cursoSaved.getId())).thenReturn(Optional.empty());
        Curso cursoFounded = cursoRepository.findById(curso.getId()).orElse(null);
        assertNull(cursoFounded);

        Mockito.verify(cursoRepository,Mockito.times(1)).save(curso);
        Mockito.verify(cursoRepository,Mockito.times(1)).delete(curso);
        Mockito.verify(cursoRepository,Mockito.times(1)).findById(cursoSaved.getId());
    }
}

package com.example.appalumnos.repositories;


import com.example.appalumnos.models.Modulo;
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
public class ModuloRepositoryIntegrationTest {
    private final Modulo modulo = new Modulo().builder()
            .name("Modulo para Test")
            .acronym("MPT")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .build();
    @Autowired
    private ModuloRepository moduloRepository;

    @Test
    @Order(1)
    void save(){
        Modulo moduloSaved = moduloRepository.save(modulo);
        assertAll(
                ()-> assertEquals(modulo.getId(),moduloSaved.getId()),
                ()-> assertEquals(modulo.getName(),moduloSaved.getName()),
                ()-> assertEquals(modulo.getAcronym(),moduloSaved.getAcronym()),
                ()-> assertEquals(modulo.getCreatedAt(),moduloSaved.getCreatedAt())
        );
    }

    @Test
    @Order(2)
    void findById(){
        Modulo moduloSaved = moduloRepository.save(modulo);
        Modulo moduloFounded = moduloRepository.findById(moduloSaved.getId()).get();
        assertAll(
                ()-> assertEquals(moduloSaved.getId(),moduloFounded.getId()),
                ()-> assertEquals(moduloSaved.getName(),moduloFounded.getName()),
                ()-> assertEquals(moduloSaved.getAcronym(),moduloFounded.getAcronym()),
                ()-> assertEquals(moduloSaved.getCreatedAt(),moduloFounded.getCreatedAt())
        );
    }

    @Test
    @Order(3)
    void findAll(){
        Modulo moduloSaved = moduloRepository.save(modulo);
        List<Modulo> modulosFounded = moduloRepository.findAll();
        assertAll(
                ()-> assertEquals(moduloSaved.getId(),modulosFounded.get(modulosFounded.size()-1).getId()),
                ()-> assertEquals(moduloSaved.getName(),modulosFounded.get(modulosFounded.size()-1).getName()),
                ()-> assertEquals(moduloSaved.getAcronym(),modulosFounded.get(modulosFounded.size()-1).getAcronym()),
                ()-> assertEquals(moduloSaved.getCreatedAt(),modulosFounded.get(modulosFounded.size()-1).getCreatedAt())
        );
    }

    @Test
    @Order(4)
    void update(){
        Modulo moduloSaved = moduloRepository.save(modulo);
        Modulo moduloFounded = moduloRepository.findById(moduloSaved.getId()).get();
        moduloFounded.setName("Name in Test Changed");
        Modulo moduloUpdated = moduloRepository.save(moduloFounded);

        assertAll(
                ()-> assertEquals(moduloFounded.getId(),moduloUpdated.getId()),
                ()-> assertEquals(moduloFounded.getName(),moduloUpdated.getName()),
                ()-> assertEquals(moduloFounded.getAcronym(),moduloUpdated.getAcronym()),
                ()-> assertEquals(moduloFounded.getCreatedAt(),moduloUpdated.getCreatedAt())
        );
    }

    @Test
    @Order(5)
    void delete(){
        Modulo moduloSaved = moduloRepository.save(modulo);
        moduloRepository.delete(modulo);
        Modulo moduloFounded = moduloRepository.findById(modulo.getId()).orElse(null);
        assertNull(moduloFounded);
    }
}

package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.models.Calificacion;
import com.example.appalumnos.models.Curso;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Levanto la BBDD en cada test
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class AlumnoRepositoryIntegrationTest {

    private final Alumno alumno = new Alumno().builder()
            .name("Alejandro")
            .email("alejandro51@gmail.com")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .updatedAt(LocalDateTime.of(2022,6,13,19,11))
            .imageAvatarUrl("https://i.pravatar.cc/300?img=51")
            .build();

    @Autowired
     private AlumnoRepository alumnoRepository;

    @Test
    @Order(1)
    void save(){
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        assertAll(
                ()-> assertEquals(alumno.getId(),alumnoSaved.getId()),
                ()-> assertEquals(alumno.getName(),alumnoSaved.getName()),
                ()-> assertEquals(alumno.getEmail(),alumnoSaved.getEmail()),
                ()-> assertEquals(alumno.getImageAvatarUrl(),alumnoSaved.getImageAvatarUrl())
        );
    }

    @Test
    @Order(2)
    void findById(){
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        Alumno alumnoFounded = alumnoRepository.findById(alumnoSaved.getId()).get();
        assertAll(
                ()-> assertEquals(alumnoSaved.getId(),alumnoFounded.getId()),
                ()-> assertEquals(alumnoSaved.getName(),alumnoFounded.getName()),
                ()-> assertEquals(alumnoSaved.getEmail(),alumnoFounded.getEmail()),
                ()-> assertEquals(alumnoSaved.getImageAvatarUrl(),alumnoFounded.getImageAvatarUrl())
        );
    }

    @Test
    @Order(3)
    void findAll(){
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        List<Alumno> alumnosFounded = alumnoRepository.findAll();
        assertAll(
                ()-> assertTrue(alumnosFounded.size()>0),
                ()-> assertEquals(alumnoSaved.getName(),alumnosFounded.get(alumnosFounded.size()-1).getName()),
                ()-> assertEquals(alumnoSaved.getEmail(),alumnosFounded.get(alumnosFounded.size()-1).getEmail()),
                ()-> assertEquals(alumnoSaved.getImageAvatarUrl(),alumnosFounded.get(alumnosFounded.size()-1).getImageAvatarUrl())
        );
    }

    @Test
    @Order(4)
    void update(){
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        Alumno alumnoFounded = alumnoRepository.findById(alumnoSaved.getId()).get();
        alumnoFounded.setName("Name in Test Changed");
        Alumno alumnoUpdated = alumnoRepository.save(alumnoFounded);

        assertAll(
                ()-> assertEquals(alumnoFounded.getId(),alumnoUpdated.getId()),
                ()-> assertEquals(alumnoFounded.getName(),alumnoUpdated.getName()),
                ()-> assertEquals(alumnoFounded.getEmail(),alumnoUpdated.getEmail()),
                ()-> assertEquals(alumnoFounded.getImageAvatarUrl(),alumnoUpdated.getImageAvatarUrl())
        );
    }

    @Test
    @Order(5)
    void delete(){
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        alumnoRepository.delete(alumno);
        Alumno alumnoFounded = alumnoRepository.findById(alumno.getId()).orElse(null);
        assertNull(alumnoFounded);
    }
}

package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.models.Calificacion;
import com.example.appalumnos.models.Modulo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlumnoRepositoryMockTest {

    private final Alumno alumno = new Alumno().builder()
            .name("Alejandro")
            .email("alejandro51@gmail.com")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .updatedAt(LocalDateTime.of(2022,6,13,19,11))
            .imageAvatarUrl("https://i.pravatar.cc/300?img=51")
            .build();

    @MockBean
    AlumnoRepository alumnoRepository;

    @Test
    @Order(1)
    void save(){
        Mockito.when(alumnoRepository.save(alumno)).thenReturn(alumno);
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        assertAll(
                ()-> assertEquals(alumno.getId(),alumnoSaved.getId()),
                ()-> assertEquals(alumno.getName(),alumnoSaved.getName()),
                ()-> assertEquals(alumno.getEmail(),alumnoSaved.getEmail()),
                ()-> assertEquals(alumno.getImageAvatarUrl(),alumnoSaved.getImageAvatarUrl()),
                ()-> assertEquals(alumno.getCreatedAt(),alumnoSaved.getCreatedAt()),
                ()-> assertEquals(alumno.getUpdatedAt(),alumnoSaved.getUpdatedAt())
        );
        Mockito.verify(alumnoRepository, Mockito.times(1)).save(alumno);
    }

    @Test
    @Order(2)
    void findById(){
        Mockito.when(alumnoRepository.findById(alumno.getId())).thenReturn(Optional.of(alumno));

        Alumno alumnoFounded = alumnoRepository.findById(alumno.getId()).get();
        assertAll(
                ()-> assertEquals(alumno.getId(),alumnoFounded.getId()),
                ()-> assertEquals(alumno.getName(),alumnoFounded.getName()),
                ()-> assertEquals(alumno.getEmail(),alumnoFounded.getEmail()),
                ()-> assertEquals(alumno.getImageAvatarUrl(),alumnoFounded.getImageAvatarUrl()),
                ()-> assertEquals(alumno.getCreatedAt(),alumnoFounded.getCreatedAt()),
                ()-> assertEquals(alumno.getUpdatedAt(),alumnoFounded.getUpdatedAt())
        );
        Mockito.verify(alumnoRepository,Mockito.times(1)).findById(alumno.getId());
    }

    @Test
    @Order(3)
    void findAll(){
        Mockito.when(alumnoRepository.findAll()).thenReturn(List.of(alumno));
        List<Alumno> alumnosFounded = alumnoRepository.findAll();
        assertAll(
                ()-> assertTrue(alumnosFounded.size()>0),
                ()-> assertEquals(alumno.getName(),alumnosFounded.get(0).getName()),
                ()-> assertEquals(alumno.getEmail(),alumnosFounded.get(0).getEmail()),
                ()-> assertEquals(alumno.getImageAvatarUrl(),alumnosFounded.get(0).getImageAvatarUrl()),
                ()-> assertEquals(alumno.getCreatedAt(),alumnosFounded.get(0).getCreatedAt()),
                ()-> assertEquals(alumno.getUpdatedAt(),alumnosFounded.get(0).getUpdatedAt())
        );
        Mockito.verify(alumnoRepository, Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    void update(){
        Mockito.when(alumnoRepository.findById(alumno.getId())).thenReturn(Optional.of(alumno));

        Alumno alumnoFounded = alumnoRepository.findById(alumno.getId()).get();
        alumnoFounded.setName("Name in Test Changed");

        Mockito.when(alumnoRepository.save(alumno)).thenReturn(alumnoFounded);

        Alumno alumnoUpdated = alumnoRepository.save(alumnoFounded);

        assertAll(
                ()-> assertEquals(alumnoFounded.getId(),alumnoUpdated.getId()),
                ()-> assertEquals(alumnoFounded.getName(),alumnoUpdated.getName()),
                ()-> assertEquals(alumnoFounded.getEmail(),alumnoUpdated.getEmail()),
                ()-> assertEquals(alumnoFounded.getImageAvatarUrl(),alumnoUpdated.getImageAvatarUrl()),
                ()-> assertEquals(alumnoFounded.getCreatedAt(),alumnoUpdated.getCreatedAt()),
                ()-> assertEquals(alumnoFounded.getUpdatedAt(),alumnoUpdated.getUpdatedAt())
        );
        Mockito.verify(alumnoRepository, Mockito.times(1)).save(alumno);
    }

    @Test
    @Order(5)
    void delete(){
        Mockito.doNothing().when(alumnoRepository).delete(alumno);
        alumnoRepository.delete(alumno);
        Mockito.when(alumnoRepository.findById(alumno.getId())).thenReturn(Optional.empty());
        Alumno alumnoFounded = alumnoRepository.findById(alumno.getId()).orElse(null);
        assertNull(alumnoFounded);
        Mockito.verify(alumnoRepository, Mockito.times(1))
                .delete(alumno);
        Mockito.verify(alumnoRepository, Mockito.times(1))
                .findById(alumno.getId());
    }
}

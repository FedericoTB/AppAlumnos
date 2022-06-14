package com.example.appalumnos.repositories;

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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModuloRepositoryMockTest {
    private final Modulo modulo = new Modulo().builder()
            .name("Modulo para Test")
            .acronym("MPT")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .build();
    @MockBean
    private ModuloRepository moduloRepository;

    @Test
    @Order(1)
    void save(){
        Mockito.when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo moduloSaved = moduloRepository.save(modulo);
        assertAll(
                ()-> assertEquals(modulo.getId(),moduloSaved.getId()),
                ()-> assertEquals(modulo.getName(),moduloSaved.getName()),
                ()-> assertEquals(modulo.getAcronym(),moduloSaved.getAcronym()),
                ()-> assertEquals(modulo.getCreatedAt(),moduloSaved.getCreatedAt())
        );
        Mockito.verify(moduloRepository,Mockito.times(1)).save(modulo);
    }

    @Test
    @Order(2)
    void findById(){
        Mockito.when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo moduloSaved = moduloRepository.save(modulo);
        Mockito.when(moduloRepository.findById(moduloSaved.getId())).thenReturn(Optional.of(modulo));
        Modulo moduloFounded = moduloRepository.findById(moduloSaved.getId()).get();
        assertAll(
                ()-> assertEquals(moduloSaved.getId(),moduloFounded.getId()),
                ()-> assertEquals(moduloSaved.getName(),moduloFounded.getName()),
                ()-> assertEquals(moduloSaved.getAcronym(),moduloFounded.getAcronym()),
                ()-> assertEquals(moduloSaved.getCreatedAt(),moduloFounded.getCreatedAt())
        );
        Mockito.verify(moduloRepository,Mockito.times(1)).save(modulo);
        Mockito.verify(moduloRepository,Mockito.times(1)).findById(moduloSaved.getId());
    }

    @Test
    @Order(3)
    void findAll(){
        Mockito.when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo moduloSaved = moduloRepository.save(modulo);
        Mockito.when(moduloRepository.findAll()).thenReturn(List.of(modulo));
        List<Modulo> modulosFounded = moduloRepository.findAll();
        assertAll(
                ()-> assertEquals(moduloSaved.getId(),modulosFounded.get(modulosFounded.size()-1).getId()),
                ()-> assertEquals(moduloSaved.getName(),modulosFounded.get(modulosFounded.size()-1).getName()),
                ()-> assertEquals(moduloSaved.getAcronym(),modulosFounded.get(modulosFounded.size()-1).getAcronym()),
                ()-> assertEquals(moduloSaved.getCreatedAt(),modulosFounded.get(modulosFounded.size()-1).getCreatedAt())
        );
        Mockito.verify(moduloRepository,Mockito.times(1)).save(modulo);
        Mockito.verify(moduloRepository,Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    void update(){
        Mockito.when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo moduloSaved = moduloRepository.save(modulo);
        Mockito.when(moduloRepository.findById(moduloSaved.getId())).thenReturn(Optional.of(modulo));
        Modulo moduloFounded = moduloRepository.findById(moduloSaved.getId()).get();
        moduloFounded.setName("Name in Test Changed");
        Mockito.when(moduloRepository.save(moduloFounded)).thenReturn(moduloFounded);
        Modulo moduloUpdated = moduloRepository.save(moduloFounded);

        assertAll(
                ()-> assertEquals(moduloFounded.getId(),moduloUpdated.getId()),
                ()-> assertEquals(moduloFounded.getName(),moduloUpdated.getName()),
                ()-> assertEquals(moduloFounded.getAcronym(),moduloUpdated.getAcronym()),
                ()-> assertEquals(moduloFounded.getCreatedAt(),moduloUpdated.getCreatedAt())
        );
        Mockito.verify(moduloRepository,Mockito.times(2)).save(modulo);
        Mockito.verify(moduloRepository,Mockito.times(1)).findById(moduloSaved.getId());
    }

    @Test
    @Order(5)
    void delete(){
        Mockito.when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo moduloSaved = moduloRepository.save(modulo);
        Mockito.doNothing().when(moduloRepository).delete(modulo);
        moduloRepository.delete(modulo);
        Mockito.when(moduloRepository.findById(moduloSaved.getId())).thenReturn(Optional.empty());
        Modulo moduloFounded = moduloRepository.findById(modulo.getId()).orElse(null);
        assertNull(moduloFounded);

        Mockito.verify(moduloRepository,Mockito.times(1)).save(modulo);
        Mockito.verify(moduloRepository,Mockito.times(1)).delete(modulo);
        Mockito.verify(moduloRepository,Mockito.times(1)).findById(moduloSaved.getId());
    }
}

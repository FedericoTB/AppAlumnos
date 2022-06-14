package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Usuario;
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
public class UsuarioRepositoryMockTest {
    private final Usuario usuario = new Usuario().builder()
            .email("test@test.com")
            .username("testname")
            .avatar("https://test.com/image?=1")
            .password("test1234")
            .fullName("Test User Test")
            .createdAt(LocalDateTime.of(2022,6,13,19,11))
            .lastPasswordChangeAt(LocalDateTime.of(2022,6,13,19,11))
            .build();
    @MockBean
    private UsuariosRepository usuariosRepository;

    @Test
    @Order(1)
    void save(){
        Mockito.when(usuariosRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        assertAll(
                ()-> assertEquals(usuario.getId(),usuarioSaved.getId()),
                ()-> assertEquals(usuario.getEmail(),usuarioSaved.getEmail()),
                ()-> assertEquals(usuario.getFullName(),usuarioSaved.getFullName()),
                ()-> assertEquals(usuario.getAvatar(),usuarioSaved.getAvatar()),
                ()-> assertEquals(usuario.getUsername(),usuarioSaved.getUsername()),
                ()-> assertEquals(usuario.getPassword(),usuarioSaved.getPassword())
        );
        Mockito.verify(usuariosRepository,Mockito.times(1)).save(usuario);
    }

    @Test
    @Order(2)
    void findById(){
        Mockito.when(usuariosRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        Mockito.when(usuariosRepository.findById(usuarioSaved.getId())).thenReturn(Optional.of(usuario));
        Usuario usuarioFounded = usuariosRepository.findById(usuarioSaved.getId()).get();
        assertAll(
                ()-> assertEquals(usuarioSaved.getId(),usuarioFounded.getId()),
                ()-> assertEquals(usuarioSaved.getEmail(),usuarioFounded.getEmail()),
                ()-> assertEquals(usuarioSaved.getFullName(),usuarioFounded.getFullName()),
                ()-> assertEquals(usuarioSaved.getAvatar(),usuarioFounded.getAvatar()),
                ()-> assertEquals(usuarioSaved.getUsername(),usuarioFounded.getUsername()),
                ()-> assertEquals(usuarioSaved.getPassword(),usuarioFounded.getPassword())
        );
        Mockito.verify(usuariosRepository,Mockito.times(1)).save(usuario);
        Mockito.verify(usuariosRepository,Mockito.times(1)).findById(usuarioSaved.getId());
    }

    @Test
    @Order(3)
    void findAll(){
        Mockito.when(usuariosRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        Mockito.when(usuariosRepository.findAll()).thenReturn(List.of(usuario));
        List<Usuario> usuariosFounded = usuariosRepository.findAll();
        assertAll(
                ()-> assertEquals(usuarioSaved.getId(),usuariosFounded.get(usuariosFounded.size()-1).getId()),
                ()-> assertEquals(usuarioSaved.getEmail(),usuariosFounded.get(usuariosFounded.size()-1).getEmail()),
                ()-> assertEquals(usuarioSaved.getFullName(),usuariosFounded.get(usuariosFounded.size()-1).getFullName()),
                ()-> assertEquals(usuarioSaved.getAvatar(),usuariosFounded.get(usuariosFounded.size()-1).getAvatar()),
                ()-> assertEquals(usuarioSaved.getUsername(),usuariosFounded.get(usuariosFounded.size()-1).getUsername()),
                ()-> assertEquals(usuarioSaved.getPassword(),usuariosFounded.get(usuariosFounded.size()-1).getPassword())
        );
        Mockito.verify(usuariosRepository,Mockito.times(1)).save(usuario);
        Mockito.verify(usuariosRepository,Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    void update(){
        Mockito.when(usuariosRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        Mockito.when(usuariosRepository.findById(usuarioSaved.getId())).thenReturn(Optional.of(usuario));
        Usuario usuarioFounded = usuariosRepository.findById(usuarioSaved.getId()).get();
        usuarioFounded.setFullName("Name in Test Changed");
        Mockito.when(usuariosRepository.save(usuarioFounded)).thenReturn(usuarioFounded);
        Usuario usuarioUpdated = usuariosRepository.save(usuarioFounded);

        assertAll(
                ()-> assertEquals(usuarioFounded.getId(),usuarioUpdated.getId()),
                ()-> assertEquals(usuarioFounded.getEmail(),usuarioUpdated.getEmail()),
                ()-> assertEquals(usuarioFounded.getFullName(),usuarioUpdated.getFullName()),
                ()-> assertEquals(usuarioFounded.getAvatar(),usuarioUpdated.getAvatar()),
                ()-> assertEquals(usuarioFounded.getUsername(),usuarioUpdated.getUsername()),
                ()-> assertEquals(usuarioFounded.getPassword(),usuarioUpdated.getPassword())
        );
        Mockito.verify(usuariosRepository,Mockito.times(2)).save(usuario);
        Mockito.verify(usuariosRepository,Mockito.times(1)).findById(usuarioSaved.getId());
    }

    @Test
    @Order(5)
    void delete(){
        Mockito.when(usuariosRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioSaved = usuariosRepository.save(usuario);
        Mockito.doNothing().when(usuariosRepository).delete(usuario);
        usuariosRepository.delete(usuario);
        Mockito.when(usuariosRepository.findById(usuarioSaved.getId())).thenReturn(Optional.empty());
        Usuario usuarioFounded = usuariosRepository.findById(usuario.getId()).orElse(null);
        assertNull(usuarioFounded);

        Mockito.verify(usuariosRepository,Mockito.times(1)).save(usuario);
        Mockito.verify(usuariosRepository,Mockito.times(1)).delete(usuario);
        Mockito.verify(usuariosRepository,Mockito.times(1)).findById(usuarioSaved.getId());
    }
}

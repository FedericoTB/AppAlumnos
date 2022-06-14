package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Alumno;
import com.example.appalumnos.models.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    @Query("SELECT a FROM Alumno a, Calificacion c where c.modulo.id = :modulo_id and c.alumno.id = a.id")
    List<Alumno> findAlumnosByCalificaciones_Modulo_id(Long modulo_id);

    Page<Alumno> findAllByNameContainsIgnoreCaseAndEmailContainsIgnoreCase(String name, String email, Pageable pageable);

    Page<Alumno> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

    Page<Alumno> findAllByEmailContainsIgnoreCase(String email, Pageable pageable);
}

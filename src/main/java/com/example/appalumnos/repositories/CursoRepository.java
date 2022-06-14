package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {

    Page<Curso> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

    Page<Curso> findAllByAcronymContainsIgnoreCase(String name, Pageable pageable);

    Page<Curso> findAllByNameContainsIgnoreCaseAndAcronymContainsIgnoreCase(String name, String acronym, Pageable pageable);
}

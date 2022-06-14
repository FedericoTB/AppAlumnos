package com.example.appalumnos.repositories;


import com.example.appalumnos.models.Modulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo,Long> {

    Page<Modulo> findAllByNameContainsIgnoreCaseAndAcronymContainsIgnoreCase(String name, String acronym, Pageable pageable);

    Page<Modulo> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

    Page<Modulo> findAllByAcronymContainsIgnoreCase(String acronym, Pageable pageable);
}

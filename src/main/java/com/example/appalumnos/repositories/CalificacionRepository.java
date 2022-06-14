package com.example.appalumnos.repositories;

import com.example.appalumnos.models.Calificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {

    Set<Calificacion> findAllByModulo_Id(Long id);

    Page<Calificacion> findAllByAlumno_Id(Long alumnoId, Pageable pageable);

    Page<Calificacion> findAllByModulo_Id(Long moduloId, Pageable pageable);

    Page<Calificacion> findAllByAlumno_IdAndModulo_Id(Long alumnoId, Long moduloId, Pageable pageable);
}

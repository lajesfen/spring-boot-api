package edu.utec.api.repository;

import org.springframework.data.repository.ListCrudRepository;
import edu.utec.api.entity.Alumno;

public interface AlumnoRepository extends ListCrudRepository<Alumno, Long> {
    
}
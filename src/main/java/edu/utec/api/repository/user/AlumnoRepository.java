package edu.utec.api.repository.user;

import org.springframework.data.repository.ListCrudRepository;

import edu.utec.api.entity.user.Alumno;

public interface AlumnoRepository extends ListCrudRepository<Alumno, Long> {
    
}
package edu.utec.api.repository.system;

import org.springframework.data.repository.ListCrudRepository;

import edu.utec.api.entity.system.Curso;

public interface CursoRepository extends ListCrudRepository<Curso, String> {
    
}
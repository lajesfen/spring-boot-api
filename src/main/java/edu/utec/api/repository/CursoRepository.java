package edu.utec.api.repository;

import org.springframework.data.repository.ListCrudRepository;
import edu.utec.api.entity.Curso;

public interface CursoRepository extends ListCrudRepository<Curso, String> {
    
}
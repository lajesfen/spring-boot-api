package edu.utec.api.repository;

import org.springframework.data.repository.ListCrudRepository;
import edu.utec.api.entity.Facultad;

public interface FacultadRepository extends ListCrudRepository<Facultad, String> {
    
}
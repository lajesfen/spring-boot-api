package edu.utec.api.repository.system;

import org.springframework.data.repository.ListCrudRepository;

import edu.utec.api.entity.system.Facultad;

public interface FacultadRepository extends ListCrudRepository<Facultad, String> {
    
}
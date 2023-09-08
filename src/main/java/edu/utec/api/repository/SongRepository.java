package me.lajesfen.api;

import org.springframework.data.repository.ListCrudRepository;

public interface SongRepository extends ListCrudRepository<Song, Long> {
    
}
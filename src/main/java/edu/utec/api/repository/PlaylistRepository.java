package me.lajesfen.api;

import org.springframework.data.repository.ListCrudRepository;

public interface PlaylistRepository extends ListCrudRepository<Playlist, Long> {
    
}
package me.lajesfen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    public ResponseEntity<List<Playlist>> playlists() {
        List<Playlist> playlists = playlistRepository.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaylist(@PathVariable Long id) {

        if (!playlistRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist with ID " + id + " not found");
        }

        Playlist existingPlaylist = playlistRepository.findById(id).get();
        return new ResponseEntity<>(existingPlaylist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> playlist(@RequestBody Playlist playlist) {
        playlistRepository.save(playlist);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {

        if (!playlistRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist with ID " + id + " not found");
        }
        
        playlist.setId(id);
        playlistRepository.save(playlist);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        if (!playlistRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist with ID " + id + " not found");
        }
        
        Playlist existingPlaylist = playlistRepository.findById(id).get();

        if (playlist.getTitle() != null) {
            existingPlaylist.setTitle(playlist.getTitle());
        }
        if (playlist.getSongs() != null) {
            existingPlaylist.setSongs(playlist.getSongs());
        }
        if (playlist.getCoverImage() != null) {
            existingPlaylist.setCoverImage(playlist.getCoverImage());
        }

        playlistRepository.save(existingPlaylist);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id) {

        if (!playlistRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist with ID " + id + " not found");
        }
        
        playlistRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
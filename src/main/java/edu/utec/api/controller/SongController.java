package me.lajesfen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public ResponseEntity<List<Song>> songs() {
        List<Song> songs = songRepository.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSong(@PathVariable Long id) {

        if (!songRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song with ID " + id + " not found");
        }

        Song existingSong = songRepository.findById(id).get();
        return new ResponseEntity<>(existingSong, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> song(@RequestBody Song song) {
        songRepository.save(song);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSong(@PathVariable Long id, @RequestBody Song song) {

        if (!songRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song with ID " + id + " not found");
        }
        
        song.setId(id);
        songRepository.save(song);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdateSong(@PathVariable Long id, @RequestBody Song song) {
        if (!songRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song with ID " + id + " not found");
        }
        
        Song existingSong = songRepository.findById(id).get();

        if (song.getTitle() != null) {
            existingSong.setTitle(song.getTitle());
        }
        if (song.getArtist() != null) {
            existingSong.setArtist(song.getArtist());
        }
        if (song.getAlbum() != null) {
            existingSong.setAlbum(song.getAlbum());
        }
        if (song.getReleaseDate() != null) {
            existingSong.setReleaseDate(song.getReleaseDate());
        }
        if (song.getGenre() != null) {
            existingSong.setGenre(song.getGenre());
        }
        if (song.getDuration() != null) {
            existingSong.setDuration(song.getDuration());
        }
        if (song.getCoverImage() != null) {
            existingSong.setCoverImage(song.getCoverImage());
        }
        if (song.getSpotifyUrl() != null) {
            existingSong.setSpotifyUrl(song.getSpotifyUrl());
        }

        songRepository.save(existingSong);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable Long id) {

        if (!songRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Song with ID " + id + " not found");
        }
        
        songRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
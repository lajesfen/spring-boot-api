package me.lajesfen.api;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private List<Long> songs;

    private String coverImage;

    public Playlist() {}

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Long> getSongs() {
        return this.songs;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public void setSongs(List<Long> songs) {
        if(songs == null) {
            throw new IllegalArgumentException("Songs list cannot be null");
        }
        this.songs = songs;
    }

    public void setCoverImage(String coverImage) {
        if (coverImage == null || coverImage.trim().isEmpty()) {
            throw new IllegalArgumentException("Cover image cannot be null or empty");
        }
        this.coverImage = coverImage;
    }
}
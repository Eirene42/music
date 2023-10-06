package com.irene.music.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> getAllAlbums() {
        return this.albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable int id) {
        Album album = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "album not found"));
        return ResponseEntity.ok(album);
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(this.albumRepository.save(album), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable int id, @RequestBody Album album) {
        Album albumToUpdate = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found to update"));

        albumToUpdate.setTitle(album.getTitle());
        albumToUpdate.setYear(album.getYear());
        albumToUpdate.setRating(album.getRating());
        albumToUpdate.setArtist(album.getArtist());
        albumToUpdate.setRecordCompany(album.getRecordCompany());

        return new ResponseEntity<>(this.albumRepository.save(albumToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable int id) {
        Album albumToDelete = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found to delete"));
        this.albumRepository.delete(albumToDelete);

        return ResponseEntity.ok(albumToDelete);
    }
}

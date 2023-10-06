package com.irene.music.artist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irene.music.album.Album;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "artists")
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private int artist_id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_members")
    private int number_of_members;

    @Column(name = "still_performing")
    private boolean still_performing;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties({"artist"})
    private List<Album> albums;

    public Artist(int artist_id, String name, int number_of_members, boolean still_performing) {
        this.artist_id = artist_id;
        this.name = name;
        this.number_of_members = number_of_members;
        this.still_performing = still_performing;
    }

    public Artist() {
    }
}

package com.irene.music.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irene.music.artist.Artist;
import com.irene.music.recordCompany.RecordCompany;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "albums")
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int album_id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties({"albums"})
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "record_company_id")
    private RecordCompany recordCompany;

    public Album(int album_id, String title, int year, int rating, Artist artist, RecordCompany recordCompany) {
        this.album_id = album_id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.artist = artist;
        this.recordCompany = recordCompany;
    }

    public Album() {
    }
}

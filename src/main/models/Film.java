package com.flexisaf.fip.filmproject.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="films")
public class Film {
    @Id
    @SequenceGenerator(
            name="film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "film_sequence"
    )
    private Long id;
    private String name;
    private String genre;
    private String description;
    private Double rating;
    private LocalDate releaseDate;


    public Long getId(){
        return this.id;
    }
    public void setId(long newId){
        this.id = newId;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getGenre(){
        return this.genre;
    }
    public void setGenre(String newGenre){
        this.genre = newGenre;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    public Double getRating(){
        return this.rating;
    }
    public void setRating(Double newRating){
        this.rating = newRating;
    }
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }
    public void setReleaseDate(LocalDate newDate){
        this.releaseDate = newDate;
    }

    public Film(){

    }
    public Film(Long id, String name, String genre, String description, double rating, LocalDate releaseDate){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }
    public Film(String name, String genre, String description, double rating, LocalDate releaseDate){
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "fId='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fGenre='" + genre + '\'' +
                ", fDescription='" + description + '\'' +
                ", fRating=" + rating +
                ", fReleaseDate=" + releaseDate +
                '}';
    }
}

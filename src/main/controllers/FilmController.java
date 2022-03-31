package com.flexisaf.fip.filmproject.controllers;

import com.flexisaf.fip.filmproject.models.Film;
import com.flexisaf.fip.filmproject.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @PostMapping
    public void addFilm(@RequestBody Film film){
        filmService.addFilm(film);
    }

    @DeleteMapping(path="{filmId}")
    public void deleteFilm(@PathVariable("filmId") Long filmId){
        filmService.deleteFilm(filmId);
    }

    @PutMapping(path="{filmId}" )
    public void updateFilm(@PathVariable("filmId") Long filmId,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String genre,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) Double rating,
                         @RequestParam(required = false) LocalDate releaseDate){
        filmService.updateFilm(filmId, name, genre, description, rating, releaseDate);
    }
}

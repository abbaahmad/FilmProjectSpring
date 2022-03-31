package com.flexisaf.fip.filmproject.services;

import com.flexisaf.fip.filmproject.repositories.FilmRepository;
import com.flexisaf.fip.filmproject.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public void addFilm(Film film) {
        Optional<Film> filmByName = filmRepository.findFilmByName(film.getName());
        if (filmByName.isPresent()) {
            throw new IllegalStateException("Film already exists");
        }
        filmRepository.save(film);
    }

    public void deleteFilm(Long filmId) {
        boolean exists = filmRepository.existsById(filmId);
        if (!exists)
            throw new IllegalStateException("Film with Id: "+filmId+" doesn't exists");
        filmRepository.deleteById(filmId);
    }

    @Transactional
    public void updateFilm(Long filmId, String name, String genre, String description,
                           Double rating, LocalDate releaseDate) {
        Optional<Film> film = filmRepository.findById(filmId);
        if(film.isEmpty()){
            throw new IllegalStateException("Can't find film with ID: "+filmId);
        }
        if (name != null && name.length() > 0 && !Objects.equals(film.get().getName(), name)) {
            film.get().setName(name);
        }
        if (genre != null && genre.length() > 0 && !Objects.equals(film.get().getGenre(), genre)) {
            film.get().setGenre(genre);
        }
        if (description != null && description.length() > 0 && !Objects.equals(film.get().getDescription(), description)) {
            film.get().setDescription(description);
        }
        if (rating != null && Math.abs(film.get().getRating() - rating) > 0.01) {
            film.get().setRating(rating);
        }
        if (releaseDate != null && !film.get().getReleaseDate().isEqual(releaseDate)) {
            film.get().setRating(rating);
        }
            filmRepository.save(film.get());
    }
}

package com.flexisaf.fip.filmproject.configurations;

import com.flexisaf.fip.filmproject.models.Film;
import com.flexisaf.fip.filmproject.repositories.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    CommandLineRunner filmCommandLineRunner(FilmRepository filmRepository){
        return args -> {
            Film avatar = new Film("Avatar", "Action", "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                        7.8, LocalDate.parse("2009-12-10"));
            Film pirates = new Film("Pirates of the Caribbean", "Action", "Captain Barbossa, Will Turner and Elizabeth Swann must sail off the edge of the map, navigate treachery and betrayal, find Jack Sparrow, and make their final alliances for one last decisive battle.",
                        7.1, LocalDate.parse("2003-06-28"));
            filmRepository.saveAll(List.of(avatar, pirates));
        };
    }
}

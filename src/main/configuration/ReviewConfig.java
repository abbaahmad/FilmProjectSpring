package com.flexisaf.fip.filmproject.configurations;

import com.flexisaf.fip.filmproject.models.Review;
import com.flexisaf.fip.filmproject.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ReviewConfig {
    @Bean
    CommandLineRunner ReviewCommandLineRunner(ReviewRepository reviewRepository){
        return args -> {
            Review avatar = new Review( "Loved the film", LocalDate.now(), LocalDate.now(), 9.9);
            Review pirates = new Review("Johnny my guy", LocalDate.now(), LocalDate.now(), 9.1);
            reviewRepository.saveAll(List.of(avatar, pirates));
        };
    }
}

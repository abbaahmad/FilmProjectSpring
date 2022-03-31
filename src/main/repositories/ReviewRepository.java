package com.flexisaf.fip.filmproject.repositories;

import com.flexisaf.fip.filmproject.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.film.id = (SELECT id FROM Film f WHERE f.name = ?1)")
    Optional<Review> findReviewByFilmName(String filmName);
}

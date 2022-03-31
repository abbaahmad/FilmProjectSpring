package com.flexisaf.fip.filmproject.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @SequenceGenerator(
            name="review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long id;
    @ManyToOne(targetEntity=Film.class, fetch=FetchType.LAZY)
    @JoinColumn(name="film_id")
    private Film film;
    private LocalDate createdOn;
    private LocalDate lastModified;
    @ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User createdBy;
    private Double userRating;
    private String review;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {return  this.film;}

    public LocalDate getCreatedOn() { return this.createdOn; }

    public void setCreatedOn(LocalDate createdOn)
    {
        this.createdOn = createdOn;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public User getCreatedBy() { return this.createdBy; }

    public Double getUserRating() { return this.userRating; }

    public void setUserRating(Double userRating)
    {
        this.userRating = userRating;
    }
    public String getReview() { return this.review; }

    public void setReview(String review)
    {
        this.review = review;
    }

    public Review(){}

    public Review(Long id, Film film, User createdBy, String review, LocalDate createdOn, LocalDate lastModified, Double userRating){
        this.id = id;
        this.createdBy = createdBy;
        this.film = film;
        this.review = review;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.userRating = userRating;
    }
    public Review(String review, LocalDate createdOn, LocalDate lastModified, Double userRating){
        this.review = review;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + id +
                ", film=" + film.getId() +
                ", createdOn=" + createdOn +
                ", lastModified=" + lastModified +
                ", createdBy='" + createdBy.getUsername() + '\'' +
                ", userRating=" + userRating +
                '}';
    }
}

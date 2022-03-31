package com.flexisaf.fip.filmproject.services;

import com.flexisaf.fip.filmproject.models.Review;
import com.flexisaf.fip.filmproject.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        boolean exists = reviewRepository.existsById(reviewId);
        if (!exists)
            throw new IllegalStateException("Review with Id: "+reviewId+" doesn't exists");
        reviewRepository.deleteById(reviewId);
    }

    @Transactional
    public void updateReview(Long reviewId, String reviewText, Double rating) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isEmpty()){
            throw new IllegalStateException("Can't find review with ID: "+reviewId);
        }
        if (reviewText != null && reviewText.length() > 0 && !Objects.equals(review.get().getReview(), reviewText)) {
            review.get().setReview(reviewText);
        }
        if (rating != null && Math.abs(review.get().getUserRating() - rating) > 0.01) {
            review.get().setUserRating(rating);
        }
        review.get().setLastModified(LocalDate.now());
        reviewRepository.save(review.get());
    }
}

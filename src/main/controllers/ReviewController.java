package com.flexisaf.fip.filmproject.controllers;

import com.flexisaf.fip.filmproject.models.Review;
import com.flexisaf.fip.filmproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public List <Review> getReviews(){
        return reviewService.getReviews();
    }
    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @DeleteMapping(path="{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId){
        reviewService.deleteReview(reviewId);
    }

    @PutMapping(path="{reviewId}" )
    public void updateReview(@PathVariable("reviewId") Long reviewId,
                             @RequestParam(required = false) String reviewText,
                             @RequestParam(required = false) Double rating){
        reviewService.updateReview(reviewId, reviewText, rating);
    }
}

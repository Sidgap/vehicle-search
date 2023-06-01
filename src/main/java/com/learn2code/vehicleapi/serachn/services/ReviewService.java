package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import com.learn2code.vehicleapi.serachn.Entity.Review;

public interface ReviewService {

	Review saveReview(Review review);

	List<Review> getAllReviews();

	Review getReviewByid(Integer id);

	Review updateReview(Review review, Integer id);

	void deleteReview(Integer id);

}

package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import com.learn2code.vehicleapi.serachn.Entity.Review;

public interface ReviewService {

	Review saveReview(Review review);

	List<Review> getAllReviews();

	Review getReviewByid(Integer reviewId);

	Review updateReview(Review review, Integer reviewId);

	void deleteReview(Integer reviewId);

	List<Review> getReviewsByProductName(String productname);

	List<Review> getReviewsByProduct(Integer id);
	
	

}

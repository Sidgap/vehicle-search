package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ReviewDao;
import com.learn2code.vehicleapi.serachn.Entity.Review;
import com.learn2code.vehicleapi.serachn.Exceptions.ReviewNotFoundException;

@Service
public class ReviewServiceimpl implements ReviewService {
	
	@Autowired
	private ReviewDao ReviewDao;

	@Override
	public Review saveReview(Review review) {
		Review dbreviewr=ReviewDao.save(review);
		return dbreviewr;
	}

	@Override
	public List<Review> getAllReviews() {
		List<Review> dballreviews=ReviewDao.findAll();
		return dballreviews;
	}

	@Override
	public Review getReviewByid(Integer id) {
		Review dbsinglereview=ReviewDao.findById(id).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +id));
		return dbsinglereview;
	}

	@Override
	public Review updateReview(Review review, Integer id) {
		Review oldreview = ReviewDao.findById(id).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +id));
		oldreview.setReview(review.getReview());
		Review updatedReview = ReviewDao.save(oldreview);
        return updatedReview;
	}

	@Override
	public void deleteReview(Integer id) {
		Review review = ReviewDao.findById(id).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +id));
		ReviewDao.delete(review);
	}

}

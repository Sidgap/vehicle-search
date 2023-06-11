package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ReviewDao;
import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.Entity.Review;
import com.learn2code.vehicleapi.serachn.Exceptions.ReviewNotFoundException;
import com.learn2code.vehicleapi.serachn.converter.ProductConverter;
import com.learn2code.vehicleapi.serachn.dto.Productdto;

@Service
public class ReviewServiceimpl implements ReviewService {
	
	@Autowired
	private ReviewDao ReviewDao;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;
	
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
	public Review getReviewByid(Integer reviewId) {
		Review dbsinglereview=ReviewDao.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +reviewId));
		return dbsinglereview;
	}

	@Override
	public Review updateReview(Review review, Integer reviewId) {
		Review oldreview = ReviewDao.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +reviewId));
		oldreview.setReview(review.getReview());
		Review updatedReview = ReviewDao.save(oldreview);
        return updatedReview;
	}

	@Override
	public void deleteReview(Integer reviewId) {
		Review review = ReviewDao.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review not found with id " +reviewId));
		ReviewDao.delete(review);
	}

	@Override
	public List<Review> getReviewsByProductName(String productname) {
		List<Review> reviews=ReviewDao.findByProduct_productname(productname);
		return reviews;
	}

	@Override
	public List<Review> getReviewsByProduct(Integer id) {
		 Productdto product = productService.getProductbyid(id);
		 Product convertproduct=productConverter.convertToEntity(product);
		 List<Review> reviews=ReviewDao.findByProduct(convertproduct);
		 return reviews;
	}

	

	

	

	
	

}

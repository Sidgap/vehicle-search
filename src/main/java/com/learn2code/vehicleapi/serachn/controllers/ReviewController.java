package com.learn2code.vehicleapi.serachn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.Review;
import com.learn2code.vehicleapi.serachn.Exceptions.ReviewNotFoundException;
import com.learn2code.vehicleapi.serachn.services.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/save")
	public ResponseEntity<Review> saveReview(@RequestBody Review review)
	{
		Review savedreview=reviewService.saveReview(review);
		return new ResponseEntity<Review>(savedreview,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Review>>getAllReviews()
	{
		List<Review> allreviews=reviewService.getAllReviews();
		return new ResponseEntity<List<Review>>(allreviews,HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{reviewId}")
	public ResponseEntity<Review> getReviewByid(@PathVariable Integer reviewId)
	{
		try
		{
			Review singlereview=reviewService.getReviewByid(reviewId);
			return new ResponseEntity<Review>(singlereview,HttpStatus.OK);
		}
		catch(ReviewNotFoundException ex)
		{
			throw new RuntimeException(ex.getMessage(),ex);
		}
	}
	
	@PutMapping("/{reviewId}")
	public ResponseEntity<Review> updateReview(@PathVariable Integer reviewId,@RequestBody Review review)
	{
		try {
	       	  
			 Review updatedreview = reviewService.updateReview(review,reviewId);
            return new ResponseEntity<>(updatedreview, HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
   }
	
	 @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Integer reviewId) {
        try {
        	reviewService.deleteReview(reviewId);
            return new ResponseEntity<>("Review deleleted with id :"+reviewId,HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
	 
	 @GetMapping("/products/name/{productname}")
	 public ResponseEntity<List<Review>> getReviewsByProductName(@PathVariable String productname) {
		 try
			{
				List<Review> reviews=reviewService.getReviewsByProductName(productname);
				return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
			}
			catch(ReviewNotFoundException ex)
			{
				throw new RuntimeException(ex.getMessage(),ex);
			}
	   
	 }
	 
	 @GetMapping("/products/{id}")
	 public ResponseEntity<List<Review>> getReviewsByProduct(@PathVariable Integer id) {
		 try
			{
				List<Review> reviews=reviewService.getReviewsByProduct(id);
				return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
			}
			catch(ReviewNotFoundException ex)
			{
				throw new RuntimeException(ex.getMessage(),ex);
			}
	   
	 }
	
}
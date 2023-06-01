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
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Review> getReviewByid(@PathVariable Integer id)
	{
		try
		{
			Review singlereview=reviewService.getReviewByid(id);
			return new ResponseEntity<Review>(singlereview,HttpStatus.OK);
		}
		catch(ReviewNotFoundException ex)
		{
			throw new RuntimeException(ex.getMessage(),ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Integer id,@RequestBody Review review)
	{
		try {
	       	  
			 Review updatedreview = reviewService.updateReview(review,id);
            return new ResponseEntity<>(updatedreview, HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
   }
	
	 @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id) {
        try {
        	reviewService.deleteReview(id);
            return new ResponseEntity<>("Review deleleted with id :"+id,HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
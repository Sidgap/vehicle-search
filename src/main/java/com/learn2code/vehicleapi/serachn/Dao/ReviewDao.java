package com.learn2code.vehicleapi.serachn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.Entity.Review;

public interface ReviewDao extends JpaRepository<Review, Integer> {

	 List<Review> findByProduct_productname(String productname);
	 
	 List<Review> findByProduct(Product product);
	
}

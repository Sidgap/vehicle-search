package com.learn2code.vehicleapi.serachn.dto;

import java.util.List;


import com.learn2code.vehicleapi.serachn.Entity.Review;

public class Productdto {

	
	private Integer id;
	
	private String productname;

	private List<Review> reviews;

	public Productdto(Integer id, String productname, List<Review> reviews) {
		super();
		this.id = id;
		this.productname = productname;
		this.reviews = reviews;
	}
	

	public Productdto() {
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}

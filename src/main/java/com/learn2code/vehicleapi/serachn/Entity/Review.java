package com.learn2code.vehicleapi.serachn.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="review")
	private String review;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
	@JsonBackReference
    private Product product;


	public Review(Integer id, String review, Product product) {
		super();
		this.id = id;
		this.review = review;
		this.product = product;
	}
	
	public Review() {
		
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
	

	
	
	
}

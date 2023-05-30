package com.learn2code.vehicleapi.serachn.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="manufacurer_name")
	@NotBlank(message="* Manufacturername cannot be blank")
	private String manufacturer_name;
	@Column(name="country")
	
	private String country;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	@JsonBackReference
	private OwnerCompany owner;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name="product_id")
	private List<Product> products;
	
	
	public Manufacturer(Integer id, String manufacturer_name,String country, OwnerCompany owner, List<Product> products) {
			
		this.id = id;
		this.manufacturer_name = manufacturer_name;
		this.country = country;
		this.owner = owner;
		this.products = products;
	}

	public Manufacturer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public OwnerCompany getOwner() {
		return owner;
	}

	public void setOwner(OwnerCompany owner) {
		this.owner = owner;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}

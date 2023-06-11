package com.learn2code.vehicleapi.serachn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehicledetails")
public class VehicleDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String modelYear;
	@NotBlank(message="BrandName cannot be blank")
	private String brandName;
	@Size(min=3,max=10,message="ModelName should lie between 3 and 10")
	private String modelName;
	private String trimType;
	private String bodyType;
	private double price;
	private int miles;
	private double interestRate;
	private String location;
	private String description;
	private String seller;
	private String sellerPhone;
	
	
	public VehicleDetails(Integer id, String modelYear, String brandName, String modelName, String trimType,
			String bodyType, double price, int miles, double interestRate, String location, String description,
			String seller, String sellerPhone) {
		super();
		this.id = id;
		this.modelYear = modelYear;
		this.brandName = brandName;
		this.modelName = modelName;
		this.trimType = trimType;
		this.bodyType = bodyType;
		this.price = price;
		this.miles = miles;
		this.interestRate = interestRate;
		this.location = location;
		this.description = description;
		this.seller = seller;
		this.sellerPhone = sellerPhone;
	}


	public VehicleDetails() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelYear() {
		return modelYear;
	}


	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getTrimType() {
		return trimType;
	}


	public void setTrimType(String trimType) {
		this.trimType = trimType;
	}


	public String getBodyType() {
		return bodyType;
	}


	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getMiles() {
		return miles;
	}


	public void setMiles(int miles) {
		this.miles = miles;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public String getSellerPhone() {
		return sellerPhone;
	}


	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	
	
	
	
	
}

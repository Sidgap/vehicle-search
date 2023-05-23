package com.learn2code.vehicleapi.serachn.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer_year")
public class Manufacture_year {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="year")
	private Integer year;
	
	
	public Manufacture_year(Integer id, Integer year) {
		super();
		this.id = id;
		this.year = year;
	}


	public Manufacture_year() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}
	
	

}

package com.learn2code.vehicleapi.serachn.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ownercompany")
public class OwnerCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL,mappedBy ="owner" )
	@JsonManagedReference
	private Manufacturer manufacturer;

	public OwnerCompany(Integer id, String name, String email, Manufacturer manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.manufacturer = manufacturer;
	}

	public OwnerCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}	
	
	
}


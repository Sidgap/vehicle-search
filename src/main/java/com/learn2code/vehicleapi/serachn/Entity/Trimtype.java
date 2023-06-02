package com.learn2code.vehicleapi.serachn.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="trimtype")
public class Trimtype {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="trimtype")
	private String trimtype;
	
	@ManyToMany(mappedBy = "trimtypes")
	@JsonIgnoreProperties("trimtypes")
	private List<Model> models;

	public Trimtype(Integer id, String trimtype, List<Model> models) {
		super();
		this.id = id;
		this.trimtype = trimtype;
		this.models = models;
	}

	public Trimtype() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrimtype() {
		return trimtype;
	}

	public void setTrimtype(String trimtype) {
		this.trimtype = trimtype;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}	
}

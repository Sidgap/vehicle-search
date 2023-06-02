package com.learn2code.vehicleapi.serachn.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="model")
public class Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="modelname")
	private String modelname;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	   @JoinTable(name = "Model_Trimtype",
	   joinColumns = @JoinColumn(name = "model_id"),
	   inverseJoinColumns = @JoinColumn(name = "trimtype_id")
	    )
	
	private List<Trimtype> trimtypes;

	public Model(Integer id, String modelname, List<Trimtype> trimtypes) {
		super();
		this.id = id;
		this.modelname = modelname;
		this.trimtypes = trimtypes;
	}
	
	public Model() {
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public List<Trimtype> getTrimtypes() {
		return trimtypes;
	}

	public void setTrimtypes(List<Trimtype> trimtypes) {
		this.trimtypes = trimtypes;
	}
	
}

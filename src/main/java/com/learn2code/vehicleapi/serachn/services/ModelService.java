package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import javax.validation.Valid;

import com.learn2code.vehicleapi.serachn.Entity.Model;

public interface ModelService  {

	Model saveModel(Model model);

	List<Model> getAllModels();

	Model getModelbyid(Integer modelId);

	Model updateModel(Integer modelId, @Valid Model model);

	void deleteModel(Integer modelId);

	List<Model> getModelsByModelName(String modelname);
	
	

	

}

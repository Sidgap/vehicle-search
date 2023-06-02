package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ModelDao;
import com.learn2code.vehicleapi.serachn.Entity.Model;
import com.learn2code.vehicleapi.serachn.Exceptions.ModelNotFoundException;



@Service
public class ModelServiceimpl implements ModelService {

	@Autowired
	private ModelDao modelDao;//Model,model
	
	@Override
	public Model saveModel(Model model) {
		Model dbsavedmodel=modelDao.save(model);
		return dbsavedmodel;
	}

	@Override
	public List<Model> getAllModels() {
		List<Model> dballmodels=modelDao.findAll();
		return dballmodels;
	}

	@Override
	public Model getModelbyid(Integer id) {
		Model dbsinglemodel=modelDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found with id " +id));
		return dbsinglemodel;
	}

	@Override
	public Model updateModel(Integer id,Model model ) {
		Model oldmodel = modelDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found with id " +id));
		oldmodel.setModelname(model.getModelname());
		Model updatedModel = modelDao.save(oldmodel);
        return updatedModel;
	   
     
      }

	@Override
	public void deleteModel(Integer id) {
		Model model = modelDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found with id " +id));
		modelDao.delete(model);
		
	}
}
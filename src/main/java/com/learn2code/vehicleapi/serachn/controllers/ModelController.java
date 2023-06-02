package com.learn2code.vehicleapi.serachn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.Model;
import com.learn2code.vehicleapi.serachn.Exceptions.ModelNotFoundException;
import com.learn2code.vehicleapi.serachn.services.ModelService;

@RestController
@RequestMapping("/api/v1/models")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@PostMapping("/save")
	public ResponseEntity<Model> saveModel(@RequestBody Model model)
	{
		Model savedmodel=modelService.saveModel(model);
		return new ResponseEntity<Model>(savedmodel,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Model>> getAllModels()
	{
		List<Model> allmodels=modelService.getAllModels();
		return new ResponseEntity<List<Model>>(allmodels,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Model> getModelbyid(@PathVariable Integer id) 
	{
		
	      try { 
	    	  Model singlemodel=modelService.getModelbyid(id);
            return new ResponseEntity<>(singlemodel, HttpStatus.OK);
            
        } catch (ModelNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Model> updateModel(@PathVariable Integer id,@Valid @RequestBody Model model) 
	{
		
		 try {
       	  
			 Model updatedmodel = modelService.updateModel( id,model);
             return new ResponseEntity<>(updatedmodel, HttpStatus.OK);
         } catch (ModelNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
    }
	
	 @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteModel(@PathVariable Integer id) {
         try {
        	 modelService.deleteModel(id);
             return new ResponseEntity<>("Model deleleted with id :"+id,HttpStatus.OK);
         } catch (ModelNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
}
	

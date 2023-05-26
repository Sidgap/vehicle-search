package com.learn2code.vehicleapi.serachn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.Manufacturer;
import com.learn2code.vehicleapi.serachn.Exceptions.ManufacturerNotFoundException;
import com.learn2code.vehicleapi.serachn.services.ManufacturerService;





@RestController
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@PostMapping("/save")
	public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer)
	{
		Manufacturer savedmaufacturer=manufacturerService.saveManufacturer(manufacturer);
		return new ResponseEntity<Manufacturer>(savedmaufacturer,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Manufacturer>> getAllManufacturer()
	{
		List<Manufacturer> allmanufacturers=manufacturerService.getAllManufacturer();
		return new ResponseEntity<List<Manufacturer>>(allmanufacturers,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Manufacturer> getManufacturerbyid(@PathVariable Integer id) 
	{
		
		
	      try { 
			Manufacturer singlemanufacturer=manufacturerService.getManufacturerbyid(id);
            return new ResponseEntity<>(singlemanufacturer, HttpStatus.OK);
            
        } catch (ManufacturerNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateManufacturer(@PathVariable Integer id,@Valid @RequestBody Manufacturer manufacturer,BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorMessage = errors.get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
		 try {
       	  
			 Manufacturer updatedmanufacturer = manufacturerService.updateManufacturer( id,manufacturer);
             return new ResponseEntity<>(updatedmanufacturer, HttpStatus.OK);
         } catch (ManufacturerNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
    }
	
	 @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteManufacturer(@PathVariable Integer id) {
         try {
        	 manufacturerService.deleteManufacturer(id);
             return new ResponseEntity<>("Manufacturer deleleted with id :"+id,HttpStatus.OK);
         } catch (ManufacturerNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
}
	

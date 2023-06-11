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
	
	@GetMapping("/get/{manufacturerId}")
	public ResponseEntity<Manufacturer> getManufacturerbyid(@PathVariable Integer manufacturerId) 
	{
		
		
	      try { 
			Manufacturer singlemanufacturer=manufacturerService.getManufacturerbyid(manufacturerId);
            return new ResponseEntity<>(singlemanufacturer, HttpStatus.OK);
            
        } catch (ManufacturerNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{manufacturerId}")
	public ResponseEntity<?> updateManufacturer(@PathVariable Integer manufacturerId,@Valid @RequestBody Manufacturer manufacturer,BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorMessages = "";
            for(ObjectError err:errors)
            {
            	errorMessages+=err.getDefaultMessage()+"\n";
            }
            return ResponseEntity.badRequest().body(errorMessages);
		}
		 try {
       	  
			 Manufacturer updatedmanufacturer = manufacturerService.updateManufacturer( manufacturerId,manufacturer);
             return new ResponseEntity<>(updatedmanufacturer, HttpStatus.OK);
         } catch (ManufacturerNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
    }
	
	 @DeleteMapping("/{manufacturerId}")
     public ResponseEntity<String> deleteManufacturer(@PathVariable Integer manufacturerId) {
         try {
        	 manufacturerService.deleteManufacturer(manufacturerId);
             return new ResponseEntity<>("Manufacturer deleleted with id :"+manufacturerId,HttpStatus.OK);
         } catch (ManufacturerNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
}
	

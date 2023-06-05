package com.learn2code.vehicleapi.serachn.controllers;

import java.util.List;

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

import com.learn2code.vehicleapi.serachn.Entity.Manufacture_year;
import com.learn2code.vehicleapi.serachn.Exceptions.ManuFactureYearNotFoundException;
import com.learn2code.vehicleapi.serachn.services.Manufacture_yearService;

@RestController
@RequestMapping("/api/v1/manufacture_year")
public class Manufacture_yearController {
	
	@Autowired
	private Manufacture_yearService manufacture_yearservice;
	
	@PostMapping("/save")
	public ResponseEntity<Manufacture_year> saveManufactureYear(@RequestBody Manufacture_year manufacture_year)
	{
		Manufacture_year savedmanufacture_year=manufacture_yearservice.saveManufactureYear(manufacture_year);
		return new ResponseEntity<Manufacture_year>(savedmanufacture_year,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Manufacture_year>> getAllManufactureYear()
	{
		List<Manufacture_year> allmanufacture_year=manufacture_yearservice.getAllManufactureYear();
		return new ResponseEntity<List<Manufacture_year>>(allmanufacture_year,HttpStatus.OK);
	}

	@GetMapping("/get/{manufactureryearId}")
	public ResponseEntity<Manufacture_year> getManufactureyearbyid(@PathVariable Integer manufactureryearId)
	{

	      try { 
	    	  Manufacture_year singlemanufactureyear=manufacture_yearservice.getManufactureyearbyid(manufactureryearId);
          return new ResponseEntity<>(singlemanufactureyear, HttpStatus.OK);
          
      } catch (ManuFactureYearNotFoundException ex) {
          throw new RuntimeException(ex.getMessage(), ex);
      }
	}
	
	@PutMapping("/{manufactureryearId}")
	public ResponseEntity<Manufacture_year> updateManufactureYear(@RequestBody Manufacture_year manufactureyear,@PathVariable Integer manufactureryearId)
	{
	try {
      	  
			Manufacture_year updatemanufactureyear=manufacture_yearservice.updateManufactureYear(manufactureyear,manufactureryearId);
            return new ResponseEntity<>(updatemanufactureyear, HttpStatus.OK);
       } catch (ManuFactureYearNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	
    }
	
	 @DeleteMapping("/{manufactureryearId}")
     public ResponseEntity<String> deleteManufactureyear(@PathVariable Integer manufactureryearId) {
         try {
        	 manufacture_yearservice.deleteManufactureyear(manufactureryearId);
             return new ResponseEntity<>("Manufactureyear deleleted with id :"+manufactureryearId,HttpStatus.OK);
         } catch (ManuFactureYearNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
}
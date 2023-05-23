package com.learn2code.vehicleapi.serachn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.Manufacture_year;
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
	

}

package com.learn2code.vehicleapi.serachn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.Manufacturer;
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
	
}

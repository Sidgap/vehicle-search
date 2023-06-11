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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicleapi.serachn.Entity.VehicleDetails;
import com.learn2code.vehicleapi.serachn.Exceptions.VehicleDetailsNotFoundException;
import com.learn2code.vehicleapi.serachn.services.VehicleDetailsService;

@RestController
@RequestMapping("/api/v1/VehicleDetails")
public class VehicleDetailsController {


	@Autowired
	private VehicleDetailsService vehicleDetailsService;//VehicleDetails,vehicledetails
	
	@PostMapping("/save")
	public ResponseEntity<?> saveVehicleDetails(@Valid @RequestBody VehicleDetails vehicledetails,BindingResult bindingResult)
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
		VehicleDetails savedvehicledetails=vehicleDetailsService.saveVehicleDetails(vehicledetails);
		return new ResponseEntity<VehicleDetails>(savedvehicledetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<VehicleDetails>> getAllVehicleDetails()
	{
		List<VehicleDetails> allvehicledetails=vehicleDetailsService.getAllVehicleDetails();
		return new ResponseEntity<List<VehicleDetails>>(allvehicledetails,HttpStatus.OK);
	}
	
	@GetMapping("/get/{vehicledetailsid}")
	public ResponseEntity<VehicleDetails> getVehicleDetailsbyid(@PathVariable Integer vehicledetailsid) 
	{
		
		
	      try { 
	    	  VehicleDetails singlevehicledetails=vehicleDetailsService.getVehicleDetailsbyid(vehicledetailsid);
            return new ResponseEntity<>(singlevehicledetails, HttpStatus.OK);
            
        } catch (VehicleDetailsNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{vehicledetailsid}")
	public ResponseEntity<?> updateVehicleDetails(@PathVariable Integer vehicledetailsid,@Valid @RequestBody VehicleDetails vehicledetails,BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            String errorMessage = errors.get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
		 try {
       	  
			 VehicleDetails updatedvehicledetails = vehicleDetailsService.updateVehicleDetails( vehicledetailsid,vehicledetails);
             return new ResponseEntity<>(updatedvehicledetails, HttpStatus.OK);
         }
		 catch (VehicleDetailsNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
    }
	
	 @DeleteMapping("/{vehicledetailsid}")
     public ResponseEntity<String> deleteVehicleDetails(@PathVariable Integer vehicledetailsid) {
         try {
        	 vehicleDetailsService.deleteVehicleDetails(vehicledetailsid);
             return new ResponseEntity<>("VehicleDetails deleleted with id :"+vehicledetailsid,HttpStatus.OK);
         } catch (VehicleDetailsNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
	 
	 @GetMapping("/filter")
	 public ResponseEntity<List<VehicleDetails>> fetchFilteredVehicleDetails(@RequestParam String modelYear,@RequestParam String brandName,@RequestParam String modelName,@RequestParam String trimType,@RequestParam String price)
	 {
		 if(price==""||price==null)
		 {
			 price="0.0";
		 }
		 List<VehicleDetails> filterdetails=vehicleDetailsService.fetchFilteredVehicleDetails(modelYear,brandName,modelName,trimType,Double.parseDouble(price));
			return new ResponseEntity<List<VehicleDetails>>(filterdetails,HttpStatus.OK);
	 }
}

	


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

import com.learn2code.vehicleapi.serachn.Entity.Trimtype;
import com.learn2code.vehicleapi.serachn.Exceptions.TrimTypeNotFoundException;
import com.learn2code.vehicleapi.serachn.services.TrimTypeService;


@RestController
@RequestMapping("/api/v1/trimtypes")
public class TrimTypeController {//Trimtype,trimtype

	@Autowired
	private TrimTypeService trimtypeService;
	
	@PostMapping("/save")
	public ResponseEntity<Trimtype> savetrimtype(@RequestBody Trimtype trimtype)
	{
		Trimtype savedtrimtype=trimtypeService.savetrimtype(trimtype);
		return new ResponseEntity<Trimtype>(savedtrimtype,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Trimtype>> getAlltrimtypes()
	{
		List<Trimtype> alltrimtypes=trimtypeService.getAlltrimtypes();
		return new ResponseEntity<List<Trimtype>>(alltrimtypes,HttpStatus.OK);
	}
	
	@GetMapping("/get/{trimtypeId}")
	public ResponseEntity<Trimtype> gettrimtypebyid(@PathVariable Integer trimtypeId) 
	{
		
	      try { 
	    	  Trimtype singletrimtype=trimtypeService.gettrimtypebyid(trimtypeId);
            return new ResponseEntity<>(singletrimtype, HttpStatus.OK);
            
        } catch (TrimTypeNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{trimtypeId}")
	public ResponseEntity<Trimtype> updatetrimtype(@PathVariable Integer trimtypeId,@Valid @RequestBody Trimtype trimtype) 
	{
		
		 try {
       	  
			 Trimtype updatedtrimtype = trimtypeService.updatetrimtype( trimtypeId,trimtype);
             return new ResponseEntity<>(updatedtrimtype, HttpStatus.OK);
         } catch (TrimTypeNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
    }
	
	 @DeleteMapping("/{trimtypeId}")
     public ResponseEntity<String> deletetrimtype(@PathVariable Integer trimtypeId) {
         try {
        	 trimtypeService.deletetrimtype(trimtypeId);
             return new ResponseEntity<>("TrimType deleleted with id :"+trimtypeId,HttpStatus.OK);
         } catch (TrimTypeNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
	
}

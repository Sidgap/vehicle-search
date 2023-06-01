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


import com.learn2code.vehicleapi.serachn.Entity.OwnerCompany;
import com.learn2code.vehicleapi.serachn.Exceptions.OwnerComanyNotfoundException;
import com.learn2code.vehicleapi.serachn.services.OwnerCompanyService;

@RestController
@RequestMapping("/api/v1/ownercompany")
public class OwnerComanyControllers {

	@Autowired
	private OwnerCompanyService ownercompanyService;
	
	@PostMapping("/save")
	public ResponseEntity<OwnerCompany> saveOwnerCompany(@RequestBody OwnerCompany ownercompany)
	{
		OwnerCompany savedownerCompany=ownercompanyService.saveOwnerCompany(ownercompany);
		return new ResponseEntity<OwnerCompany>(savedownerCompany,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<OwnerCompany>> getAllOwnerCompanies()
	{
		List<OwnerCompany> allownerCompanies=ownercompanyService.getAllOwnerCompanies();
		return new ResponseEntity<List<OwnerCompany>>(allownerCompanies,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<OwnerCompany> getOwnerCompanybyid(@PathVariable Integer id) 
	{
		
		
	      try { 
	    	  OwnerCompany singleownercompany=ownercompanyService.getOwnerCompanybyid(id);
            return new ResponseEntity<>(singleownercompany, HttpStatus.OK);
            
        } catch (OwnerComanyNotfoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OwnerCompany> updateOwnerCompany(@RequestBody OwnerCompany ownercompany,@PathVariable Integer id)
	{
	try {
      	  
		OwnerCompany updateownercompany=ownercompanyService.updateOwnerCompany(ownercompany,id);
            return new ResponseEntity<>(updateownercompany, HttpStatus.OK);
       } catch (OwnerComanyNotfoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	
    }
	
	 @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteOwnerCompany(@PathVariable Integer id) {
         try {
        	 ownercompanyService.deleteOwnerCompany(id);
             return new ResponseEntity<>("Ownercompany deleleted with id :"+id,HttpStatus.OK);
         } catch (OwnerComanyNotfoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
	
}

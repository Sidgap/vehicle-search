package com.learn2code.vehicleapi.serachn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.learn2code.vehicleapi.serachn.Exceptions.ProductNotFoundException;
import com.learn2code.vehicleapi.serachn.dto.Productdto;
import com.learn2code.vehicleapi.serachn.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Productdto> saveProduct(@RequestBody Productdto product)
	{
		Productdto savedproduct=productService.saveProduct(product);
		return new ResponseEntity<Productdto>(savedproduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Productdto>> getAllProducts()
	{
		List<Productdto> allproducts=productService.getAllProducts();
		return new ResponseEntity<List<Productdto>>(allproducts,HttpStatus.OK);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<Productdto> getProductbyid(@PathVariable Integer productId) 
	{
		
		
	      try { 
	    	  Productdto singleproduct=productService.getProductbyid(productId);
            return new ResponseEntity<>(singleproduct, HttpStatus.OK);
            
        } catch (ProductNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Productdto> updateProduct(@RequestBody Productdto product,@PathVariable Integer productId)
	{
	try {
      	  
		Productdto updateproduct=productService.updateProduct(product,productId);
		 return new ResponseEntity<>(updateproduct, HttpStatus.OK);
         
       } catch (ProductNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	
    }
	
	 @DeleteMapping("/{productId}")
     public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
         try {
        	 productService.deleteProduct(productId);
             return new ResponseEntity<>("Product deleleted with id :"+productId,HttpStatus.OK);
         } catch (ProductNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }
	 
	 @GetMapping("/{pageNumber}/{pageSize}/{sort}")
     public List < Productdto > getProducts(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sort) {
       Page < Productdto > data = productService.getProductsPagination(pageNumber, pageSize, sort);
       return data.getContent();
     }
	 
	 

}

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

import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.Exceptions.ProductNotFoundException;
import com.learn2code.vehicleapi.serachn.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		Product savedproduct=productService.saveProduct(product);
		return new ResponseEntity<Product>(savedproduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> allproducts=productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allproducts,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductbyid(@PathVariable Integer id) 
	{
		
		
	      try { 
	    	  Product singleproduct=productService.getProductbyid(id);
            return new ResponseEntity<>(singleproduct, HttpStatus.OK);
            
        } catch (ProductNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Integer id)
	{
	try {
      	  
		Product updateproduct=productService.updateProduct(product,id);
		 return new ResponseEntity<>(updateproduct, HttpStatus.OK);
         
       } catch (ProductNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
	
    }
	
	 @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
         try {
        	 productService.deleteProduct(id);
             return new ResponseEntity<>("Product deleleted with id :"+id,HttpStatus.OK);
         } catch (ProductNotFoundException ex) {
             throw new RuntimeException(ex.getMessage(), ex);
         }
     }

}

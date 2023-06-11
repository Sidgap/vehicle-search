package com.learn2code.vehicleapi.serachn.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.dto.Productdto;
@Component
public class ProductConverter {

	  public Productdto convertToDto(Product product) {
	        return new Productdto(product.getId(), product.getProductname(), product.getReviews());
	    }

	    public List<Productdto> convertToDtoList(List<Product> products) {
	        List<Productdto> productDTOs = new ArrayList<>();

	        for (Product product : products) {
	        	productDTOs.add(convertToDto(product));
	        }

	        return productDTOs;
	    }

	    public Product convertToEntity(Productdto productDTO) {
	        return new Product(productDTO.getId(), productDTO.getProductname(), productDTO.getReviews());
	    }
	
}

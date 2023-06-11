package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.learn2code.vehicleapi.serachn.dto.Productdto;

public interface ProductService {

	Productdto saveProduct(Productdto productj);

	List<Productdto> getAllProducts();

	Productdto getProductbyid(Integer productId);

	Productdto updateProduct(Productdto product, Integer productId);

	void deleteProduct(Integer productId);

	Page<Productdto> getProductsPagination(Integer pageNumber, Integer pageSize, String sort);

	

}

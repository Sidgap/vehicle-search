package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import com.learn2code.vehicleapi.serachn.Entity.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductbyid(Integer id);

	Product updateProduct(Product product, Integer id);

	void deleteProduct(Integer id);

}

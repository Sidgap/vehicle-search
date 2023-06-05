package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ProductDao;
import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.Exceptions.ProductNotFoundException;

@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
	private ProductDao ProductDao;

	@Override
	public Product saveProduct(Product product) {
		Product dbproduct=ProductDao.save(product);
		return dbproduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> dballproducts=ProductDao.findAll();
		return dballproducts;
	}

	@Override
	public Product getProductbyid(Integer productId) {
		Product dbsingleproduct=ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		return dbsingleproduct;
	}

	@Override
	public Product updateProduct(Product product, Integer productId) {
		Product oldproduct = ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		oldproduct.setProductname(product.getProductname());
		Product updatedProduct = ProductDao.save(oldproduct);
        return updatedProduct;
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product = ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		ProductDao.delete(product);
	}

	

}

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
	public Product getProductbyid(Integer id) {
		Product dbsingleproduct=ProductDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +id));
		return dbsingleproduct;
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		Product oldproduct = ProductDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +id));
		oldproduct.setProductname(product.getProductname());
		Product updatedProduct = ProductDao.save(oldproduct);
        return updatedProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = ProductDao.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +id));
		ProductDao.delete(product);
	}

}

package com.learn2code.vehicleapi.serachn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ProductDao;
import com.learn2code.vehicleapi.serachn.Entity.Product;
import com.learn2code.vehicleapi.serachn.Exceptions.ProductNotFoundException;
import com.learn2code.vehicleapi.serachn.converter.ProductConverter;
import com.learn2code.vehicleapi.serachn.dto.Productdto;

@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
	private ProductDao ProductDao;
	
	@Autowired
	private ProductConverter productConverter;

	@Override
	public Productdto saveProduct(Productdto product) {
		Product savedproduct = productConverter.convertToEntity(product);
		Product dbproduct=ProductDao.save(savedproduct);
		return productConverter.convertToDto(dbproduct);
	}

	@Override
	public List<Productdto> getAllProducts() {
		List<Product> dballproducts=ProductDao.findAll();
		return productConverter.convertToDtoList(dballproducts);
	}

	@Override
	public Productdto getProductbyid(Integer productId) {
		Product dbsingleproduct=ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		return productConverter.convertToDto(dbsingleproduct);
	}

	@Override
	public Productdto updateProduct(Productdto product, Integer productId) {
		Product oldproduct = ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		oldproduct.setProductname(product.getProductname());
		Product updatedProduct = ProductDao.save(oldproduct);
        return productConverter.convertToDto(updatedProduct);
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product = ProductDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id " +productId));
		ProductDao.delete(product);
	}

	@Override
	public Page<Productdto> getProductsPagination(Integer pageNumber, Integer pageSize, String sort) {
		  Pageable pageable = null;
		    if (sort != null) {
		      // with sorting
		      pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
		    } else {
		      // without sorting
		      pageable = PageRequest.of(pageNumber, pageSize);
		    }
		    Page<Product> productPage = ProductDao.findAll(pageable);
		    List<Product> productList = productPage.getContent();
		    List<Productdto> productDtoList = new ArrayList<>();
		   

		    for (Product product : productList) {
		        Productdto productDto = productConverter.convertToDto(product);
		        productDtoList.add(productDto);
		    }

		    return new PageImpl<>(productDtoList, pageable, productPage.getTotalElements());

		  }
	}


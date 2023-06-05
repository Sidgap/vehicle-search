package com.learn2code.vehicleapi.serachn.Dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicleapi.serachn.Entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	
}

package com.learn2code.vehicleapi.serachn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicleapi.serachn.Entity.Model;

public interface ModelDao extends JpaRepository<Model, Integer> {
	 List<Model> findBymodelname(String modelName);
}

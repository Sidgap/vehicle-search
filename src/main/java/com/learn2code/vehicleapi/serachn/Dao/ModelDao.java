package com.learn2code.vehicleapi.serachn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicleapi.serachn.Entity.Model;

public interface ModelDao extends JpaRepository<Model, Integer> {

}

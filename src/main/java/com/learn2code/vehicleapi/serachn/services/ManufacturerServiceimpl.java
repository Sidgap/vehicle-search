package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ManufacturerDao;
import com.learn2code.vehicleapi.serachn.Entity.Manufacturer;
import com.learn2code.vehicleapi.serachn.Exceptions.ManufacturerNotFoundException;

@Service
public class ManufacturerServiceimpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao ManufacturerDao;
	
	@Override
	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		Manufacturer dbsavedmanufacturer=ManufacturerDao.save(manufacturer);
		return dbsavedmanufacturer;
	}

	@Override
	public List<Manufacturer> getAllManufacturer() {
		List<Manufacturer> dballmanufacturer=ManufacturerDao.findAll();
		return dballmanufacturer;
	}

	@Override
	public Manufacturer getManufacturerbyid(Integer id) {
		Manufacturer dbsinglemanufacturer=ManufacturerDao.findById(id).orElseThrow(() -> new ManufacturerNotFoundException("Manufacturer not found with id " +id));;
		return dbsinglemanufacturer;
	}
	

}

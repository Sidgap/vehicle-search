package com.learn2code.vehicleapi.serachn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ManufacturerDao;
import com.learn2code.vehicleapi.serachn.Entity.Manufacturer;

@Service
public class ManufacturerServiceimpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao ManufacturerDao;
	
	@Override
	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		Manufacturer dbsavedmanufacturer=ManufacturerDao.save(manufacturer);
		return dbsavedmanufacturer;
	}
	

}

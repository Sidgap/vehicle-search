package com.learn2code.vehicleapi.serachn.services;

import java.util.List;
import java.util.Objects;

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
	public Manufacturer getManufacturerbyid(Integer manufacturerId) {
		Manufacturer dbsinglemanufacturer=ManufacturerDao.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException("Manufacturer not found with id " +manufacturerId));
		return dbsinglemanufacturer;
	}

	@Override
	public Manufacturer updateManufacturer(Integer manufacturerId,Manufacturer manufacturer ) {
		Manufacturer oldmanufacturer = ManufacturerDao.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException("Manufacturer not found with id " +manufacturerId));
		if(oldmanufacturer!=null&&Objects.nonNull(manufacturer))
		{
			if(Objects.nonNull(manufacturer.getManufacturer_name())&&!"".equalsIgnoreCase(manufacturer.getManufacturer_name()))
			{
				oldmanufacturer.setManufacturer_name(manufacturer.getManufacturer_name());
			}
			if(Objects.nonNull(manufacturer.getCountry())&&!"".equalsIgnoreCase(manufacturer.getCountry()))
			{
				oldmanufacturer.setCountry(manufacturer.getCountry());
			}
		}
        Manufacturer updatedmanufacturer = ManufacturerDao.save(oldmanufacturer);
        return updatedmanufacturer;
	   
     
      }

	@Override
	public void deleteManufacturer(Integer manufacturerId) {
		Manufacturer manufacturer = ManufacturerDao.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException("Manufacturer not found with id " +manufacturerId));
		ManufacturerDao.delete(manufacturer);
		
	}
}

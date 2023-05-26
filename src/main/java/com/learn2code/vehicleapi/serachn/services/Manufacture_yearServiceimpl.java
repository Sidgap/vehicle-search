package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ManufactureYearDao;
import com.learn2code.vehicleapi.serachn.Entity.Manufacture_year;
import com.learn2code.vehicleapi.serachn.Exceptions.ManuFactureYearNotFoundException;



@Service
public class Manufacture_yearServiceimpl implements Manufacture_yearService {
	
	@Autowired
	private ManufactureYearDao manufacture_yeardao;

	@Override
	public Manufacture_year saveManufactureYear(Manufacture_year manufacture_year) {
		
		Manufacture_year dbmanufacture_year=manufacture_yeardao.save(manufacture_year);
		return dbmanufacture_year;
	}

	@Override
	public List<Manufacture_year> getAllManufactureYear() {
		List<Manufacture_year> dballmanufacture_year=manufacture_yeardao.findAll();
		return dballmanufacture_year;
	}

	@Override
	public Manufacture_year getManufactureyearbyid(Integer id) {
		Manufacture_year dbsinglemanufactureyear=manufacture_yeardao.findById(id).orElseThrow(() -> new ManuFactureYearNotFoundException("ManufacturerYear not found with id " +id));
		return dbsinglemanufactureyear;
	}

	@Override
	public Manufacture_year updateManufactureYear(Manufacture_year manufactureyear, Integer id) {
		Manufacture_year oldmanufactureyear = manufacture_yeardao.findById(id).orElseThrow(() -> new ManuFactureYearNotFoundException("Manufactureryear not found with id " +id));
		oldmanufactureyear.setYear(manufactureyear.getYear());
		Manufacture_year updatedManufactureyear = manufacture_yeardao.save(oldmanufactureyear);
        return updatedManufactureyear;
	}

}

package com.learn2code.vehicleapi.serachn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.ManufactureYearDao;
import com.learn2code.vehicleapi.serachn.Entity.Manufacture_year;

@Service
public class Manufacture_yearServiceimpl implements Manufacture_yearService {
	
	@Autowired
	private ManufactureYearDao manufacture_yeardao;

	@Override
	public Manufacture_year saveManufactureYear(Manufacture_year manufacture_year) {
		
		Manufacture_year dbmanufacture_year=manufacture_yeardao.save(manufacture_year);
		return dbmanufacture_year;
	}

}

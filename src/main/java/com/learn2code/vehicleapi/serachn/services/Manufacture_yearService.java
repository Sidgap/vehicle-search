package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import com.learn2code.vehicleapi.serachn.Entity.Manufacture_year;

public interface Manufacture_yearService {

	Manufacture_year saveManufactureYear(Manufacture_year manufacture_year);

	List<Manufacture_year> getAllManufactureYear();

	Manufacture_year getManufactureyearbyid(Integer id);

	Manufacture_year updateManufactureYear(Manufacture_year manufactureyear, Integer id);

	void deleteManufactureyear(Integer id);

	

}

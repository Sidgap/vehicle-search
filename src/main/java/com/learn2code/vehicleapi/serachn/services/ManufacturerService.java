package com.learn2code.vehicleapi.serachn.services;

import java.util.List;



import com.learn2code.vehicleapi.serachn.Entity.Manufacturer;

public interface ManufacturerService  {

	Manufacturer saveManufacturer(Manufacturer manufacturer);

	List<Manufacturer> getAllManufacturer();

	Manufacturer getManufacturerbyid(Integer manufacturerId);

	Manufacturer updateManufacturer(Integer manufacturerId,Manufacturer manufacturer);

	void deleteManufacturer(Integer manufacturerId);

	

}

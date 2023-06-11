package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import javax.validation.Valid;

import com.learn2code.vehicleapi.serachn.Entity.VehicleDetails;

public interface VehicleDetailsService {

	VehicleDetails saveVehicleDetails(VehicleDetails vehicledetails);

	List<VehicleDetails> getAllVehicleDetails();

	VehicleDetails getVehicleDetailsbyid(Integer vehicledetailsid);

	VehicleDetails updateVehicleDetails(Integer vehicledetailsid, @Valid VehicleDetails vehicledetails);

	void deleteVehicleDetails(Integer vehicledetailsid);

	List<VehicleDetails> fetchFilteredVehicleDetails(String modelYear, String brandName, String modelName,String trimType, double price);
			
}

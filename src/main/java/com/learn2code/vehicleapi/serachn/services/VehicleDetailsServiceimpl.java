package com.learn2code.vehicleapi.serachn.services;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.VehicleDetailsDao;
import com.learn2code.vehicleapi.serachn.Entity.VehicleDetails;
import com.learn2code.vehicleapi.serachn.Exceptions.VehicleDetailsNotFoundException;

@Service
public class VehicleDetailsServiceimpl implements VehicleDetailsService {

	
	@Autowired
	private VehicleDetailsDao vehicleDetailsDao;
	
	@Override
	public VehicleDetails saveVehicleDetails(VehicleDetails vehicledetails) {
		VehicleDetails dbsavedvehicledetails=vehicleDetailsDao.save(vehicledetails);
		return dbsavedvehicledetails;
	}

	@Override
	public List<VehicleDetails> getAllVehicleDetails() {
		List<VehicleDetails> dballvehicledetails=vehicleDetailsDao.findAll();
		return dballvehicledetails;
	}

	@Override
	public VehicleDetails getVehicleDetailsbyid(Integer vehicledetailsid) {
		VehicleDetails dbsinglevehicledetails=vehicleDetailsDao.findById(vehicledetailsid).orElseThrow(() -> new VehicleDetailsNotFoundException("VehicleDetails not found with id " +vehicledetailsid));
		return dbsinglevehicledetails;
	}

	@Override
	public VehicleDetails updateVehicleDetails(Integer vehicledetailsid, @Valid VehicleDetails vehicledetails) {
		VehicleDetails oldvehicledetails = vehicleDetailsDao.findById(vehicledetailsid).orElseThrow(() -> new VehicleDetailsNotFoundException("VehicleDetails not found with id " +vehicledetailsid));
		if(oldvehicledetails!=null&&Objects.nonNull(vehicledetails))
		{
			if(Objects.nonNull(vehicledetails.getModelYear())&&!"".equalsIgnoreCase(vehicledetails.getModelYear()))
			{
				oldvehicledetails.setModelYear(vehicledetails.getModelYear());
			}
			if(Objects.nonNull(vehicledetails.getBrandName())&&!"".equalsIgnoreCase(vehicledetails.getBrandName()))
			{
				oldvehicledetails.setBrandName(vehicledetails.getBrandName());
			}
			if(Objects.nonNull(vehicledetails.getModelName())&&!"".equalsIgnoreCase(vehicledetails.getModelName()))
			{
				oldvehicledetails.setModelName(vehicledetails.getModelName());
			}
			if(Objects.nonNull(vehicledetails.getTrimType())&&!"".equalsIgnoreCase(vehicledetails.getTrimType()))
			{
				oldvehicledetails.setTrimType(vehicledetails.getTrimType());
			}
			if(Objects.nonNull(vehicledetails.getBodyType())&&!"".equalsIgnoreCase(vehicledetails.getBodyType()))
			{
				oldvehicledetails.setBodyType(vehicledetails.getBodyType());
			}
			if(Objects.nonNull(vehicledetails.getPrice()))
			{
				oldvehicledetails.setPrice(vehicledetails.getPrice());
			}
			if(Objects.nonNull(vehicledetails.getMiles()))
			{
				oldvehicledetails.setMiles(vehicledetails.getMiles());
			}
			if(Objects.nonNull(vehicledetails.getInterestRate()))
			{
				oldvehicledetails.setInterestRate(vehicledetails.getInterestRate());
			}
			if(Objects.nonNull(vehicledetails.getLocation())&&!"".equalsIgnoreCase(vehicledetails.getLocation()))
			{
				oldvehicledetails.setLocation(vehicledetails.getLocation());
			}
			if(Objects.nonNull(vehicledetails.getDescription())&&!"".equalsIgnoreCase(vehicledetails.getDescription()))
			{
				oldvehicledetails.setDescription(vehicledetails.getDescription());
			}
			if(Objects.nonNull(vehicledetails.getSeller())&&!"".equalsIgnoreCase(vehicledetails.getSeller()))
			{
				oldvehicledetails.setSeller(vehicledetails.getSeller());
			}
			if(Objects.nonNull(vehicledetails.getSellerPhone())&&!"".equalsIgnoreCase(vehicledetails.getSellerPhone()))
			{
				oldvehicledetails.setSellerPhone(vehicledetails.getSellerPhone());
			}
		}
		VehicleDetails updatedvehicledetails = vehicleDetailsDao.save(oldvehicledetails);
        return updatedvehicledetails;
	}

	@Override
	public void deleteVehicleDetails(Integer vehicledetailsid) {
		VehicleDetails vehicledetails = vehicleDetailsDao.findById(vehicledetailsid).orElseThrow(() -> new VehicleDetailsNotFoundException("VehicleDetails not found with id " +vehicledetailsid));
		vehicleDetailsDao.delete(vehicledetails);
	}

	@Override
	public List<VehicleDetails> fetchFilteredVehicleDetails(String modelYear, String brandName, String modelName,String trimType, double price) {
			
		List<VehicleDetails> filterdetailslist=null;
		if(modelYear!=""&&brandName!=""&&modelName!=""&&trimType!=""&&price>0.0)
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria(modelYear,brandName,modelName,trimType,price);
		}
		else if(brandName!=""&&modelName!=""&&trimType!=""&&price>0.0)
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria1(brandName,modelName,trimType,price);
		}
		else if(brandName!=""&&modelName!=""&&trimType!="")
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria2(brandName,modelName,trimType);
		}
		else if(brandName!=""&&modelName!=""&&price>0.0)
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria3(brandName,modelName,price);
		}
		else if(brandName!=""&&price>0.0)
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria4(brandName,price);
		}
		else if(brandName!="")
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria5(brandName);
		}
		else if(price>0.0)
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria6(price);
		}
		else if(modelYear!="")
		{
			filterdetailslist=vehicleDetailsDao.findFilteredDetailsBasedONCriteria7(modelYear);
		}
		else
		{
			filterdetailslist=getAllVehicleDetails();
		}
	
	
	return filterdetailslist;
	}
	
}

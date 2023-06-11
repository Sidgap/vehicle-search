package com.learn2code.vehicleapi.serachn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learn2code.vehicleapi.serachn.Entity.VehicleDetails;

public interface VehicleDetailsDao extends JpaRepository<VehicleDetails, Integer> {

	@Query(value="SELECT * FROM vehicledetails WHERE model_year=?1 AND brand_name=?2 AND model_name=?3 AND trim_type=?4 AND price<=?5",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria(String modelYear, String brandName, String modelName,String trimType, double price);
			
	@Query(value="SELECT * FROM vehicledetails WHERE brand_name=?1 AND model_name=?2 AND trim_type=?3 AND price<=?4",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria1(String brandName, String modelName,String trimType, double price);
			
	@Query(value="SELECT * FROM vehicledetails WHERE brand_name=?1 AND model_name=?2 AND trim_type=?3",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria2( String brandName, String modelName,String trimType);
			
	@Query(value="SELECT * FROM vehicledetails WHERE brand_name=?1 AND model_name=?2 price<=?3",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria3(String brandName, String modelName,double price);
			
	@Query(value="SELECT * FROM vehicledetails WHERE brand_name=?1 price<=?2",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria4(String brandName,double price);
			
	@Query(value="SELECT * FROM vehicledetails WHERE brand_name=?1",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria5(String brandName);
	
	@Query(value="SELECT * FROM vehicledetails WHERE price<=?1",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria6(double price);
	
	@Query(value="SELECT * FROM vehicledetails WHERE model_year=?1",nativeQuery = true)
	List<VehicleDetails> findFilteredDetailsBasedONCriteria7(String modelYear);
}

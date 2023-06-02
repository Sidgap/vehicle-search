package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import javax.validation.Valid;

import com.learn2code.vehicleapi.serachn.Entity.Trimtype;

public interface TrimTypeService {

	Trimtype savetrimtype(Trimtype model);

	List<Trimtype> getAlltrimtypes();

	Trimtype gettrimtypebyid(Integer id);

	Trimtype updatetrimtype(Integer id, @Valid Trimtype trimtype);

	void deletetrimtype(Integer id);

}

package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import javax.validation.Valid;

import com.learn2code.vehicleapi.serachn.Entity.Trimtype;

public interface TrimTypeService {

	Trimtype savetrimtype(Trimtype model);

	List<Trimtype> getAlltrimtypes();

	Trimtype gettrimtypebyid(Integer trimtypeId);

	Trimtype updatetrimtype(Integer trimtypeId, @Valid Trimtype trimtype);

	void deletetrimtype(Integer trimtypeId);

}

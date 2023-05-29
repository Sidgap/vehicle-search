package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import com.learn2code.vehicleapi.serachn.Entity.OwnerCompany;

public interface OwnerCompanyService {

	OwnerCompany saveOwnerCompany(OwnerCompany ownercompany);

	List<OwnerCompany> getAllOwnerCompanies();

	OwnerCompany getOwnerCompanybyid(Integer id);

	OwnerCompany updateOwnerCompany(OwnerCompany ownercompany, Integer id);

	void deleteOwnerCompany(Integer id);

}

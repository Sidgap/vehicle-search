package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.OwnerComanyDao;
import com.learn2code.vehicleapi.serachn.Entity.OwnerCompany;
import com.learn2code.vehicleapi.serachn.Exceptions.OwnerComanyNotfoundException;

@Service
public class OwnerComanyServiceimpl implements OwnerCompanyService {
	
	@Autowired
	private OwnerComanyDao ownercompanydao;

	@Override
	public OwnerCompany saveOwnerCompany(OwnerCompany ownercompany) {
		OwnerCompany dbownercompany=ownercompanydao.save(ownercompany);
		return dbownercompany;
	}

	@Override
	public List<OwnerCompany> getAllOwnerCompanies() {
		List<OwnerCompany> dballownercompanies=ownercompanydao.findAll();
		return dballownercompanies;
	}

	@Override
	public OwnerCompany getOwnerCompanybyid(Integer ownerCompanyId) {
		OwnerCompany dbsingledownercompany=ownercompanydao.findById(ownerCompanyId).orElseThrow(() -> new OwnerComanyNotfoundException("OwnerCompany not found with id " +ownerCompanyId));
		return dbsingledownercompany;
	}

	@Override
	public OwnerCompany updateOwnerCompany(OwnerCompany ownercompany, Integer ownerCompanyId) {
		OwnerCompany oldownercompany = ownercompanydao.findById(ownerCompanyId).orElseThrow(() -> new OwnerComanyNotfoundException("OwnerCompany not found with id " +ownerCompanyId));
		oldownercompany.setName(ownercompany.getName());
		oldownercompany.setEmail(ownercompany.getEmail());
		oldownercompany.setManufacturer(ownercompany.getManufacturer());
		OwnerCompany updatedOwnerCompany = ownercompanydao.save(oldownercompany);
        return updatedOwnerCompany;
	}

	@Override
	public void deleteOwnerCompany(Integer ownerCompanyId) {
		OwnerCompany ownercompany = ownercompanydao.findById(ownerCompanyId).orElseThrow(() -> new OwnerComanyNotfoundException("OwnerCompany not found with id " +ownerCompanyId));
		ownercompanydao.delete(ownercompany);
		
	}

}

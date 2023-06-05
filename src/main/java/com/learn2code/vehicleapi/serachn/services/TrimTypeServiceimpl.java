package com.learn2code.vehicleapi.serachn.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicleapi.serachn.Dao.TrimTypeDao;
import com.learn2code.vehicleapi.serachn.Entity.Trimtype;
import com.learn2code.vehicleapi.serachn.Exceptions.TrimTypeNotFoundException;

@Service
public class TrimTypeServiceimpl implements TrimTypeService {

	
	@Autowired
	private TrimTypeDao TrimTypeDao;
	
	@Override
	public Trimtype savetrimtype(Trimtype trimtype) {
		Trimtype dbtrimtype=TrimTypeDao.save(trimtype);
		return dbtrimtype;
	}

	@Override
	public List<Trimtype> getAlltrimtypes() {
		List<Trimtype> dballtrimtypes=TrimTypeDao.findAll();
		return dballtrimtypes;
	}

	@Override
	public Trimtype gettrimtypebyid(Integer trimtypeId) {
		Trimtype dbsingletrimtype=TrimTypeDao.findById(trimtypeId).orElseThrow(() -> new TrimTypeNotFoundException("TrimType not found with id " +trimtypeId));
		return dbsingletrimtype;
	}

	@Override
	public Trimtype updatetrimtype(Integer trimtypeId, @Valid Trimtype trimtype) {
		Trimtype oldtrimtype = TrimTypeDao.findById(trimtypeId).orElseThrow(() -> new TrimTypeNotFoundException("TrimType not found with id " +trimtypeId));
		oldtrimtype.setTrimtype(trimtype.getTrimtype());
		Trimtype updatedTrimtype = TrimTypeDao.save(oldtrimtype);
        return updatedTrimtype;
	}

	@Override
	public void deletetrimtype(Integer trimtypeId) {
		Trimtype trimtype = TrimTypeDao.findById(trimtypeId).orElseThrow(() -> new TrimTypeNotFoundException("TrimType not found with id " +trimtypeId));
		TrimTypeDao.delete(trimtype);
	}

}

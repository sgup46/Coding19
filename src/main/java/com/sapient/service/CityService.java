package com.sapient.service;

import com.sapient.dao.CityServiceDAO;
import com.sapient.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityService implements IService {
	
	@Autowired
	CityServiceDAO cityServiceDAO;

	/**
	 * Will save the city instance
	 * @param c
	 * @return
	 */
	public City save(City c) {
		return cityServiceDAO.save(c);
	}


	/**
	 * find all the cities
	 * @return
	 */
	public List<City> getCity( ){
		return cityServiceDAO.getCity();
	}

	public City findOne(long cityID) {
		return cityServiceDAO.findOne(cityID);
	}

	

}

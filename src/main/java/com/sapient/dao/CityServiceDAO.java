package com.sapient.dao;

import com.sapient.model.City;
import com.sapient.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityServiceDAO implements IServiceDAO{
	
	@Autowired
	CityRepository theCityRepository;

	/**
	 * Will save the city instance
	 * @param c
	 * @return
	 */
	public City save(City c) {
		return theCityRepository.save(c);
	}


	/**
	 * find all the cities
	 * @return
	 */
	public List<City> getCity( ){
		return theCityRepository.findAll();
	}

	public City findOne(long cityID) {
		return theCityRepository.findById(cityID).get();
	}

	

}

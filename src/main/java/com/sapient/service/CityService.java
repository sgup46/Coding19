package com.sapient.service;

import com.sapient.model.City;
import com.sapient.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
	
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
	
//	update City 
	
	
//	get City by ID
	public City findOne(long cityID) {
		return theCityRepository.getOne(cityID);
	}
	
//	Delete city
	public void deletecity(City c) {
		theCityRepository.delete(c);
	}
	

}

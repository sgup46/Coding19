package com.sapient.service;

import com.sapient.model.City;
import com.sapient.model.Theater;
import com.sapient.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
	
	@Autowired
	TheaterRepository theTheaterRepository;
	
	//Save Theater
	public Theater save(Theater t) {
		return theTheaterRepository.save(t);
	}
	
//	get all theater 
	public List<Theater> getTheater(){
		return theTheaterRepository.findAll();
	}
	
//	get Theater by ID
	
	public Theater findOne(long ID){
		
		return theTheaterRepository.getOne(ID);
		
	}
	
//	Delete theater
	public void deleteTheater(Theater t) {
		theTheaterRepository.delete(t);
	}
	
//	Find theater by city ID
	public List<Theater> gettheaterByCityId(City c){
		return theTheaterRepository.findByCity(c);
	}

	public List<Object[]> getTheatresByMovieAndShowTimings(long ID, String movieName, String showTime, String showDate){
		return theTheaterRepository.getTheatresByMovieAndShowTimings(ID, movieName, showTime, showDate);
	}
	

}

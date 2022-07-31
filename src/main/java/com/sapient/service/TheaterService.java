package com.sapient.service;

import com.sapient.dao.TheaterServiceDAO;
import com.sapient.model.City;
import com.sapient.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TheaterService {
	
	@Autowired
	TheaterServiceDAO theaterServiceDAO;

	public Theater save(Theater t) {
		return theaterServiceDAO.save(t);
	}

	
	public Theater findOne(long ID){
		
		return theaterServiceDAO.findOne(ID);
		
	}

	public List<Theater> getTheaterByCityId(City c){
		return theaterServiceDAO.getTheaterByCityId(c);
	}

	public List<Object[]> getTheatresByMovieAndShowTimings(long ID, String movieName, String showTime, String showDate){
		return theaterServiceDAO.getTheatresByMovieAndShowTimings(ID, movieName, showTime, showDate);
	}
	

}

package com.sapient.service;

import com.sapient.dao.TheaterServiceDAO;
import com.sapient.model.City;
import com.sapient.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
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

	public List<Theater> getTheatresByMovieAndShowTimings(long ID, String movieName, String showTime, String showDate){
		List<Object[]> theatres =  theaterServiceDAO.getTheatresByMovieAndShowTimings(ID, movieName, showTime, showDate);
		List<Theater> listTheatres = new ArrayList<>();
		if (!CollectionUtils.isEmpty(theatres)) {
			theatres.stream().forEach( theatreObjectArray -> {
                 Theater t = new Theater();
				 t.setTheater_id(((BigInteger) theatreObjectArray[0]).longValue());
				t.setTheater_name((String) theatreObjectArray[1]);
				t.setTheater_area((String) theatreObjectArray[2]);
				listTheatres.add(t);
			});
		}
		return listTheatres;
	}
	

}

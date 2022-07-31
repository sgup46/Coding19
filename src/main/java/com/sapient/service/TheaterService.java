package com.sapient.service;

import com.sapient.dao.IServiceDAO;
import com.sapient.dao.MovieServiceDAO;
import com.sapient.dao.TheaterServiceDAO;
import com.sapient.model.City;
import com.sapient.model.Theater;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Data
public class TheaterService implements IService {
	
	@Autowired
	@Qualifier("theaterServiceDAO")
	IServiceDAO theaterServiceDAO;

	public Theater save(Theater t) {
		return ((TheaterServiceDAO)theaterServiceDAO).save(t);
	}

	
	public Theater findOne(long ID){
		
		return ((TheaterServiceDAO)theaterServiceDAO).findOne(ID);
		
	}

	public List<Theater> getTheaterByCityId(City c){
		return ((TheaterServiceDAO)theaterServiceDAO).getTheaterByCityId(c);
	}

	public List<Theater> getTheatresByMovieAndShowTimings(long ID, String movieName, String showTime, String showDate){
		List<Object[]> theatres =  ((TheaterServiceDAO)theaterServiceDAO).getTheatresByMovieAndShowTimings(ID, movieName, showTime, showDate);
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

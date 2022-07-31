package com.sapient.service;

import com.sapient.dao.MovieServiceDAO;
import com.sapient.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieService {

	
	@Autowired
	MovieServiceDAO movieServiceDAO;
	
	public Movie save(Movie m) {
		return movieServiceDAO.save(m);
	}
	
	public List<Movie> getMovie(){
		return movieServiceDAO.getMovie();
	}
	
	public Movie findOne(long ID){
		return movieServiceDAO.findOne(ID);
	}

	public List<Movie> getMovieByTheaterId(long ID){
		List<Object[]> movies =  movieServiceDAO.getMovieByTheaterId(ID);
		List<Movie> listMovies = new ArrayList<>();
		if (!CollectionUtils.isEmpty(movies)) {
			movies.stream().forEach( movieObjectArray -> {
				Movie t = new Movie();
				t.setMovie_id(((BigInteger) movieObjectArray[0]).longValue());
				t.setMovie_name((String) movieObjectArray[1]);
				t.setMovie_description((String) movieObjectArray[2]);
				listMovies.add(t);
			});
		}
		return listMovies;
	}
	
}

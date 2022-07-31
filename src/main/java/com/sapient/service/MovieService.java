package com.sapient.service;

import com.sapient.dao.MovieServiceDAO;
import com.sapient.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

	public List<Object[]> getMovieByTheaterId(long ID){
		return movieServiceDAO.getMovieByTheaterId(ID);
	}
	
}

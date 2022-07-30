package com.sapient.service;

import com.sapient.model.Movie;
import com.sapient.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieService {

	
	@Autowired
	MovieRepository movieRepository;
	
	public Movie save(Movie m) {
		return movieRepository.save(m);
	}
	
	public List<Movie> getMovie(){
		return movieRepository.findAll();
	}
	
	public Movie findOne(long ID){
		return movieRepository.findById(ID).get();
	}

	public List<Object[]> getMovieByTheaterId(long ID){
		return movieRepository.getMovieByTheateID(ID);
	}
	
}

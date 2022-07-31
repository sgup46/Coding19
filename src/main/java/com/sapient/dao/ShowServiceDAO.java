package com.sapient.dao;

import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import com.sapient.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ShowServiceDAO implements IServiceDAO{


	@Autowired
	MovieServiceDAO theMovieService;

	@Autowired
	TheaterServiceDAO theTheaterService;

	@Autowired
	ShowRepository theShowRepository;
	
	public Show save(Show theShow)
	{
		return theShowRepository.save(theShow);
	}
	
	public List<Show> fetchAllShow(){
		return theShowRepository.findAll();
		
	}

	public void delete(Show theShow) {
		theShowRepository.delete(theShow);
	}

	public List<Show> fetchByMovie(Movie m){
		return theShowRepository.findBytheMovie(m);
	}


	public Show updateShow(long id, long movie_id, String show_time) {
		Theater theTheater = theTheaterService.findOne(id);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
		theShow.setShow_time(show_time);
		return theShow;
	}
}

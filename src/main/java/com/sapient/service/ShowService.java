package com.sapient.service;

import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import com.sapient.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShowService {


	@Autowired
	MovieService theMovieService;

	@Autowired
	TheaterService theTheaterService;

	@Autowired
	ShowRepository theShowRepository;
	
	public Show createShow(long ID, long movie_id, String show_time)
	{
		Theater theTheater = theTheaterService.findOne(ID);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = new Show();
		theShow.setShow_time(show_time);
		theShow.setShow_date(new Date());
		theShow.setTheMovie(theMovie);
		theShow.setTheTheater(theTheater);
		return theShowRepository.save(theShow);
	}
	
	public List<Show> fetchAllShow(){
		return theShowRepository.findAll();
		
	}

	public void deleteShow(long id, long movie_id) {
		Theater theTheater = theTheaterService.findOne(id);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
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

package com.sapient.service;

import com.sapient.dao.MovieServiceDAO;
import com.sapient.dao.ShowServiceDAO;
import com.sapient.dao.TheaterServiceDAO;
import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShowService {


	@Autowired
	MovieServiceDAO movieServiceDAO;

	@Autowired
	TheaterServiceDAO theaterServiceDAO;

	@Autowired
	ShowServiceDAO showServiceDAO;
	
	public Show createShow(long ID, long movie_id, String show_time)
	{
		Theater theTheater = theaterServiceDAO.findOne(ID);
		Movie theMovie = movieServiceDAO.findOne(movie_id);
		Show theShow = new Show();
		theShow.setShow_time(show_time);
		theShow.setShow_date(new Date());
		theShow.setTheMovie(theMovie);
		theShow.setTheTheater(theTheater);
		return showServiceDAO.save(theShow);
	}
	
	public List<Show> fetchAllShow(){
		return showServiceDAO.fetchAllShow();
		
	}

	public boolean deleteShow(long id, long movie_id) {
		Theater theTheater = theaterServiceDAO.findOne(id);
		Movie theMovie = movieServiceDAO.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
		showServiceDAO.delete(theShow);
		return true;
	}

	public List<Show> fetchByMovie(Movie m){
		return showServiceDAO.fetchByMovie(m);
	}


	public Show updateShow(long id, long movie_id, String show_time) {
		Theater theTheater = theaterServiceDAO.findOne(id);
		Movie theMovie = movieServiceDAO.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
		theShow.setShow_time(show_time);
		return theShow;
	}
}

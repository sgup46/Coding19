package com.sapient.controller;


import com.sapient.model.City;
import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import com.sapient.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class B2BController {
	
	@Autowired
	CityService theCityService;
	
	@Autowired
	MovieService theMovieService;
	
	@Autowired
	TheaterService theTheaterService;
	
	@Autowired
	ShowService theShowService;
	
	@Autowired
	BookingsService theBookingsService;


	/**
	 * Create the city
	 * @param c
	 * @return
	 */
	@PostMapping("/city")
	public City createCity(@Valid @RequestBody City c) {
		return theCityService.save(c);
	}


	/**
	 * Create the movie
	 * @param m
	 * @return
	 */
	@PostMapping("/movie")
	public Movie createMovie(@Valid @RequestBody Movie m) {
		return theMovieService.save(m);
	}

	/**
	 * Create a theatre
	 * @param city
	 * @param requestData
	 * @return
	 */
	@PostMapping("/{city}/theater")
	public Theater createTheater(@PathVariable(value="city") long city, @Valid @RequestBody HashMap<String, String> requestData) {
		Theater theTheater = new Theater();
		theTheater.setTheater_name(requestData.get("name"));
		theTheater.setTheater_area(requestData.get("area"));
		City theCity = theCityService.findOne(city);
		theTheater.setCity(theCity);
		return theTheaterService.save(theTheater);
	}


	/**
	 * create a new show to the theatreId  and movieId
	 * @param ID
	 * @param movie_id
	 * @param requestData
	 * @return
	 */
	@PostMapping("/{ID}/{movie_id}/createShow")
	public Show createShow(@PathVariable(value = "ID") long ID, @PathVariable(value = "movie_id") long movie_id,
						   @Valid @RequestBody HashMap<String, String> requestData) {
		Theater theTheater = theTheaterService.findOne(ID);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = new Show();
		Show theResponseShow = new Show();
		theShow.setShow_time(requestData.get("show_time"));
		theShow.setShow_date(new Date());
		theShow.setTheMovie(theMovie);
		theShow.setTheTheater(theTheater);
		theResponseShow = theShowService.save(theShow);
		return theResponseShow;
	}

	/**
	 * Update the show
	 * @param ID
	 * @param movie_id
	 * @param requestData
	 * @return
	 */
	@PostMapping("/{ID}/{movie_id}/updateshow")
	public Show updateShow(@PathVariable(value = "ID") long ID, @PathVariable(value = "movie_id") long movie_id,
						   @Valid @RequestBody HashMap<String, String> requestData) {
		Theater theTheater = theTheaterService.findOne(ID);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
		theShow.setShow_time(requestData.get("show_time"));
		Show theResponseShow = theShowService.save(theShow);
		return theResponseShow;
	}

	/**
	 * delete the show
	 * @param ID
	 * @param movie_id
	 * @return
	 */
	@PostMapping("/{ID}/{movie_id}/deleteShow")
	public ResponseEntity<Show> deleteShow(@PathVariable(value = "ID") long ID, @PathVariable(value = "movie_id") long movie_id) {
		Theater theTheater = theTheaterService.findOne(ID);
		Movie theMovie = theMovieService.findOne(movie_id);
		Show theShow = theMovie.getTheShow().stream().findFirst().get();
		theShowService.deleteShow(theShow);
		return ResponseEntity.ok().build();
	}

}











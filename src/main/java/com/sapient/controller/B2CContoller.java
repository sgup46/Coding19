package com.sapient.controller;

import com.sapient.model.City;
import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import com.sapient.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class B2CContoller {

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
	 * Get the list of cities
	 * @return
	 */
	@GetMapping("/city")
	public List<City> getAllCity(){
		
		return theCityService.getCity();
	}


	/**
	 * get the theatre in city
	 * @param ID
	 * @return
	 */
	@GetMapping("/{ID}/theater")
	public List<Theater> getTheaterInCity(@PathVariable(value = "ID") long ID){
		
		City theCity = theCityService.findOne(ID);
		
		return theTheaterService.gettheaterByCityId(theCity);
	}

	/**
	 * Get the movies by TheatreId
	 * @param ID
	 * @return
	 */
	@GetMapping("/theater/{ID}/movie")
	public List<Object[]> getMovieByTheaterID(@PathVariable(value = "ID") long ID){

		return theMovieService.getMovieByTheaterId(ID);
	}


	/**
	 * Get the shows by movieId
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}/show")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = theMovieService.findOne(id);
	
		return theShowService.fetchByMovie(theMovie);
	}

	/**
	 * get the theatre in city
	 * @param ID
	 * @return
	 */
	@GetMapping("/{ID}/{movieName}/{showTime}/{showDate}/theater")
	public List<Object[]> getTheatresByMovieAndShowTimings(@PathVariable(value = "ID") long ID, @PathVariable(value = "movieName") String movieName,
										  @PathVariable(value = "showTime") String showTime, @PathVariable(value = "showDate") String showDate){
		return theTheaterService.getTheatresByMovieAndShowTimings(ID , movieName, showTime, showDate);
	}

	
}







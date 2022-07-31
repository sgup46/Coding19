package com.sapient.controller;

import com.sapient.model.City;
import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import com.sapient.service.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Data
public class B2CContoller {

	@Autowired
	@Qualifier("cityService")
	IService theCityService;

	@Autowired
	@Qualifier("movieService")
	IService theMovieService;

	@Autowired
	@Qualifier("theaterService")
	IService theTheaterService;

	@Autowired
	@Qualifier("showService")
	IService theShowService;

	@Autowired
	@Qualifier("bookingsService")
	IService theBookingsService;


	/**
	 * Get the list of cities
	 * @return
	 */
	@GetMapping("/city")
	public List<City> getAllCity(){
		
		return ((CityService)theCityService).getCity();
	}


	/**
	 * get the theatre in city
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/theater")
	public List<Theater> getTheaterInCity(@PathVariable(value = "id") long id){
		
		City theCity = ((CityService)theCityService).findOne(id);
		
		return ((TheaterService)theTheaterService).getTheaterByCityId(theCity);
	}

	/**
	 * Get the movies by TheatreId
	 * @param ID
	 * @return
	 */
	@GetMapping("/theater/{ID}/movie")
	public List<Movie> getMovieByTheaterID(@PathVariable(value = "ID") long ID){

		return ((MovieService)theMovieService).getMovieByTheaterId(ID);
	}


	/**
	 * Get the shows by movieId
	 * @param ID
	 * @return
	 */
	@GetMapping("/movie/{ID}/show")
	public List<Show> geShowByMovieId(@PathVariable(value = "ID") long ID){
		
		Movie theMovie = ((MovieService)theMovieService).findOne(ID);
	
		return ((ShowService)theShowService).fetchByMovie(theMovie);
	}

	/**
	 * get the theatre in city
	 * @param ID
	 * @return
	 */
	@GetMapping("/{ID}/{movieName}/{showTime}/{showDate}/theater")
	public List<Theater> getTheatresByMovieAndShowTimings(@PathVariable(value = "ID") long ID, @PathVariable(value = "movieName") String movieName,
										  @PathVariable(value = "showTime") String showTime, @PathVariable(value = "showDate") String showDate){
		return ((TheaterService)theTheaterService).getTheatresByMovieAndShowTimings(ID , movieName, showTime, showDate);
	}

	
}







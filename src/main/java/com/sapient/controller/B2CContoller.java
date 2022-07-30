package com.sapient.controller;

import com.sapient.model.*;
import com.sapient.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
	
//	Get Movie available on the theaters
	
	@GetMapping("/theater/{ID}/movie")
	public List<Object[]> getMovieByTheaterID(@PathVariable(value = "ID") long ID){
		
		return theMovieService.getMovieByTheaterId(ID);
	}
	
//	Get Available Show for a particular movie 
	
	@GetMapping("/movie/{id}/show")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = theMovieService.findOne(id);
	
		return theShowService.fetchByMovie(theMovie);
	}
	
//	Get the seat available for a particular Show using the show ID
	
	@GetMapping("/show/{id}")
	public Bookings getAvailableSeat(@PathVariable ( value = "id") long id)
	{
		return theBookingsService.getAvailableSeat(id);
	}
	
//	Book a Seat using the show id By passing the show POJO to the API 
	
	@PostMapping("show/{id}/bookings")
	public Bookings bookSeatForShow(@PathVariable (value = "id") long id, @Valid @RequestBody Bookings b)
	{
		return theBookingsService.bookTheSeat(b);
	}
	
	
	
}







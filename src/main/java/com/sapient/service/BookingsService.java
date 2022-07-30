package com.sapient.service;

import com.sapient.model.Booking;
import com.sapient.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {

	@Autowired
	BookingsRepository theBookingsRepository;
	
//	Get the available seat for the movie 
	public Booking getAvailableSeat(long showID) {
		return theBookingsRepository.getOne(showID);
	}
	
//	Book the seat 
	public Booking bookTheSeat(Booking book) {
		return theBookingsRepository.save(book);
	}
	
}

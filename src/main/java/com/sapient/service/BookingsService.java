package com.sapient.service;

import com.sapient.model.Booking;
import com.sapient.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookingsService {

	@Autowired
	BookingsRepository theBookingsRepository;
	
	public Booking getAvailableSeat(long showID) {
		return theBookingsRepository.getOne(showID);
	}
	
	public Booking bookTheSeat(Booking book) {
		return theBookingsRepository.save(book);
	}
	
}

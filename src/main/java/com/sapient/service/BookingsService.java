package com.sapient.service;

import com.sapient.dao.BookingsServiceDAO;
import com.sapient.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookingsService implements IService {

	@Autowired
	BookingsServiceDAO bookingsServiceDAO;
	
	public Booking getAvailableSeat(long showID) {

		return bookingsServiceDAO.getAvailableSeat(showID);
	}
	
	public Booking bookTheSeat(Booking book) {

		return bookingsServiceDAO.bookTheSeat(book);
	}
	
}

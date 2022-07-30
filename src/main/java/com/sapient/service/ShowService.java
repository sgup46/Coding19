package com.sapient.service;

import com.sapient.model.Movie;
import com.sapient.model.Show;
import com.sapient.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShowService {

	@Autowired
	ShowRepository theShowRepository;
	
	public Show save(Show show)
	{
		return theShowRepository.save(show);
	}
	
	public List<Show> fetchAllShow(){
		return theShowRepository.findAll();
		
	}

	public void deleteShow(Show s) {
		theShowRepository.delete(s);
	}

	public List<Show> fetchByMovie(Movie m){
		return theShowRepository.findBytheMovie(m);
	}
}

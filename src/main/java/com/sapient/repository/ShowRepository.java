package com.sapient.repository;

import com.sapient.model.Movie;
import com.sapient.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	public List<Show> findBytheMovie(Movie m);
}

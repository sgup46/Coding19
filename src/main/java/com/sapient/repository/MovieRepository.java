package com.sapient.repository;

import com.sapient.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "select movie_id, movie_name, movie_description from movie, show as s  where s.the_theater_theater_id = ?1", nativeQuery = true)
	public List<Object[]> getMovieByTheateID(long ID);

}

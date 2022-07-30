package com.sapient.repository;

import com.sapient.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "select m.movie_id, m.movie_name, m.movie_description from movie m, show as s  " +
			"where s.the_theater_theater_id = ?1 and m.movie_id=s.the_movie_movie_id", nativeQuery = true)
	public List<Object[]> getMovieByTheateID(long ID);

}

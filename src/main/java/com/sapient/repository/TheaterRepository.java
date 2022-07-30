package com.sapient.repository;

import com.sapient.model.City;
import com.sapient.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City ID);

	@Query(value = "select movie_id, movie_name, movie_description from movie, show as s  " +
			"where s.the_theater_theater_id = ?1", nativeQuery = true)
	public List<Object[]> getTheaturesByMovieAndShowTiming(long ID);
}

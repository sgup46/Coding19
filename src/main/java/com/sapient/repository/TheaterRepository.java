package com.sapient.repository;

import com.sapient.model.City;
import com.sapient.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City ID);
}

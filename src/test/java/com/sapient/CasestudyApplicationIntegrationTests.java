package com.sapient;

import com.sapient.controller.B2BController;
import com.sapient.controller.B2CContoller;
import com.sapient.model.Show;
import com.sapient.model.Theater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CasestudyApplicationIntegrationTests {

	@Autowired
	B2CContoller b2CContoller;

	@Autowired
	B2BController b2BContoller;

	@Test
	public void contextLoads() {
		Assertions.assertTrue(b2CContoller!=null);
	}

	@Test
	public void testB2CContollerGetTheatresByMovieAndShowTimings() {
		List<Theater> theatres =  b2CContoller.getTheatresByMovieAndShowTimings(1, "WAR 3",
				"6:00 PM", LocalDate.now().toString());
		Assertions.assertNotNull(theatres.get(0).getTheater_id());
		Assertions.assertNotNull(theatres.get(0).getTheater_name());
		Assertions.assertNotNull(theatres.get(0).getTheater_name().equals("Finox mall"));
		Assertions.assertNotNull(theatres.get(0).getTheater_area());
		Assertions.assertNotNull(theatres.get(0).getTheater_area().equals("Koramangala"));
	}

	@Test
	public void testB2BContollerCreateShow() {
		HashMap request = new HashMap();
		request.put("show_time", "\"3:30 PM\"");
		Show show =  b2BContoller.addShowToTheaterForMovie(6L,
				10L, request);
		Assertions.assertNotNull(show);
		Assertions.assertNotNull(show.getShow_Id());
		Assertions.assertEquals(show.getShow_Id(), 1);
	}

	@Test
	public void testB2BContollerUpdateShow() {
		HashMap request = new HashMap();
		request.put("show_time", "\"6:30 PM\"");
		Show show =  b2BContoller.addShowToTheaterForMovie(6L,
				10L, request);
		Assertions.assertNotNull(show);
		Assertions.assertNotNull(show.getShow_Id());
	}

	@Test
	public void testB2BContolleDeleteShow() {
		HashMap request = new HashMap();
		b2BContoller.deleteShowToTheaterForMovie(6L,
				10L);
	}
}

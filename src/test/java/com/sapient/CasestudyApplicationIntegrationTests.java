package com.sapient;

import com.sapient.controller.B2BController;
import com.sapient.controller.B2CContoller;
import com.sapient.model.Show;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
		List<Object[]> theatres =  b2CContoller.getTheatresByMovieAndShowTimings(1, "WAR 3", "6:00 PM", "2022-07-31");
		Assertions.assertNotNull(theatres.get(0)[0]);
		Assertions.assertNotNull(theatres.get(0)[1]);
		Assertions.assertNotNull(theatres.get(0)[1].equals("Finox mall"));
		Assertions.assertNotNull(theatres.get(0)[2]);
		Assertions.assertNotNull(theatres.get(0)[2].equals("Koramangala"));
	}

	@Test
	public void testB2BContollerCreateShow() {
		HashMap request = new HashMap();
		request.put("show_time", "\"3:30 PM\"");
		Show show =  b2BContoller.createShow(6L,
				10L, request);
		Assertions.assertNotNull(show);
		Assertions.assertNotNull(show.getShow_Id());
		Assertions.assertEquals(show.getShow_Id(), 1);
	}

	@Test
	public void testB2BContollerUpdateShow() {
		HashMap request = new HashMap();
		request.put("show_time", "\"6:30 PM\"");
		Show show =  b2BContoller.createShow(6L,
				10L, request);
		Assertions.assertNotNull(show);
		Assertions.assertNotNull(show.getShow_Id());
	}

	@Test
	public void testB2BContolleDeleteShow() {
		HashMap request = new HashMap();
		b2BContoller.deleteShow(6L,
				10L);
	}
}

package com.sapient.controller;

import com.sapient.model.Show;
import com.sapient.service.*;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
@Data
public class B2BontollerTest {

    @InjectMocks
    B2BController b2BContoller;

    @Mock
    CityService theCityService;

    @Mock
    MovieService theMovieService;

    @Mock
    TheaterService theTheaterService;

    @Mock
    ShowService theShowService;

    @Mock
    BookingsService theBookingsService;


    @Test
    public void testB2BContollerCreateShow() {
        Show s = new Show();
        s.setShow_Id(1L);

        HashMap request = new HashMap();
        request.put("show_time", "\"3:30 PM\"");
        s.setShow_date(new Date());

        Mockito.when(theShowService.createShow(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(s);
        b2BContoller.setTheShowService(theShowService);
        Show show =  b2BContoller.createShow(6L,
                10L, request);
        Assertions.assertNotNull(show);
        Assertions.assertNotNull(show.getShow_Id());
        Assertions.assertNotNull(show.getShow_date());
    }

    @Test
    public void testB2BContollerUpdateShow() {
        Show s = new Show();
        s.setShow_Id(1L);

        HashMap request = new HashMap();
        request.put("show_time", "\"3:30 PM\"");
        s.setShow_date(new Date());

        Mockito.when(theShowService.updateShow(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(s);
        b2BContoller.setTheShowService(theShowService);
        Show show =  b2BContoller.updateShow(6L,
                10L, request);
        Assertions.assertNotNull(show);
        Assertions.assertNotNull(show.getShow_Id());
        Assertions.assertNotNull(show.getShow_date());
    }

    @Test
    public void testB2BContolleDeleteShow() {
        Show s = new Show();
        s.setShow_Id(1L);


        s.setShow_date(new Date());

        Mockito.when(theShowService.deleteShow(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        b2BContoller.setTheShowService(theShowService);
        b2BContoller.deleteShow(6L,
                10L);

    }
}

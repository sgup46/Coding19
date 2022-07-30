package com.sapient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BOOKINGS")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Booking {
	
	@Id
	private long booking_id;

	private Date show_date;

	private String show_time;

	private String movie_name;

	private String seat_id;
	
}

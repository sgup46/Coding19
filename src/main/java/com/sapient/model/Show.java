package com.sapient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SHOW")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Show {
	
	@Id
	@GeneratedValue
	private long show_Id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Theater theTheater;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Movie theMovie;
	
	@NotBlank
	private Date show_date;

	private String show_time;

}

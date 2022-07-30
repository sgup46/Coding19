package com.sapient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="THEATER")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Theater {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Theater_id;
	

	private String Theater_name;
	

	private String Theater_area;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private City city;

	
	@OneToMany(mappedBy = "theTheater")
	private List<Show> theShow;
	


}

 package com.sapient.model;

 import lombok.Data;
 import org.hibernate.validator.constraints.NotBlank;
 import org.springframework.data.jpa.domain.support.AuditingEntityListener;

 import javax.persistence.*;
 import java.util.List;

@Entity
@Table(name="CITY")
@EntityListeners(AuditingEntityListener.class)
@Data
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long city_id;
	
	@Column(nullable=false)
	@NotBlank
	private String city_name;
	
	@NotBlank
	private String city_pincode;
	
	@NotBlank
	private String city_state;
	
	@OneToMany(mappedBy="city")
	private List<Theater> theTheater;
//

}

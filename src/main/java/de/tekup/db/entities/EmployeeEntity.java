package de.tekup.db.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	@Id
	private int id;
	@Column(length=50)
	private String name;
	@Column(length=70, nullable=false, unique=true)
	private String email;
	
	private LocalDate dob;

}

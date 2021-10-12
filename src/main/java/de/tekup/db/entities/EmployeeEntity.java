package de.tekup.db.entities;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String name;
	@Column(length=70, nullable=false, unique=true)
	private String email;
	
	private LocalDate dob;
	@OneToOne
	private Matricule matricule;

}

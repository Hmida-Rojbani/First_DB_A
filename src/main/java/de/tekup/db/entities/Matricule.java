package de.tekup.db.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Matricule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private LocalDate expireDate;
	
	private String creator;
	
	@JsonIgnore
	@OneToOne(mappedBy = "matricule")
	private EmployeeEntity employee;
	

}

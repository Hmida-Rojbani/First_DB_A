package de.tekup.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private LocalDate beginDate;
	
	private LocalDate endDate;
	
	@ManyToMany
	@JoinTable(name = "projectTeam",
	joinColumns = @JoinColumn(name="project"),
	inverseJoinColumns = @JoinColumn(name="employee"))
	private List<EmployeeEntity> employees = new ArrayList<>();

}

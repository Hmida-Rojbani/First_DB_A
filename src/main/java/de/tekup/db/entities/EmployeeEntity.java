package de.tekup.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String name;
	@Column(length = 70, nullable = false, unique = true)
	private String email;

	private LocalDate dob;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Matricule matricule;

	@JsonIgnore
	@ManyToMany(mappedBy = "employees")
	private List<Project> projects = new ArrayList<>();

	@Transient
	private List<String> projectsTitles;

	public List<String> getProjectsTitles() {
		return this.projects.stream()
				.map(p -> p.getTitle())
				.collect(Collectors.toList());
	}
	
}

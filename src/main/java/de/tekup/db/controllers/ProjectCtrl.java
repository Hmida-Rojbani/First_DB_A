package de.tekup.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Matricule;
import de.tekup.db.entities.Project;
import de.tekup.db.services.ProjectService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectCtrl {
	
	private ProjectService projectService;
	

	@PostMapping()
	public Project saveProject(@RequestBody Project project) {
		return projectService.addNewProject(project);
	}
	
	@GetMapping
	public List<Project> getAll(){
		return projectService.getAllProjects();
	}
	
	@PostMapping("/{id}/add/employee")
	public EmployeeEntity addEmployeeToProject(@PathVariable int id,
			@RequestBody EmployeeEntity employeeEntity) {
		return projectService.addEmployeeToProject(id, employeeEntity);
	}

}

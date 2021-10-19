package de.tekup.db.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Project;
import de.tekup.db.repositories.ProjectRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectService {
	
	private ProjectRepository projectRepository;
	
	public Project addNewProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project getProjectById(int projectID) {
		return projectRepository.findById(projectID)
			.orElseThrow(()-> new NoSuchElementException("Project id not found"));
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public EmployeeEntity addEmployeeToProject(int idProject, EmployeeEntity employeeEntity) {
		Project project = getProjectById(idProject);
		project.getEmployees().add(employeeEntity);
		employeeEntity.getProjects().add(project);
		projectRepository.save(project);
		return employeeEntity;
	}
	// code version
	public List<Project> getStillOpenProjects(){
		LocalDate now = LocalDate.now();
		List<Project> projects = projectRepository.findAll();
		projects.removeIf(p -> p.getEndDate().isBefore(now));
		return projects;
	}
	
	public List<Project> getStillOpenProjectsSql(){
		LocalDate now = LocalDate.now();
		return projectRepository.getOpenProjects(now);
	}
}

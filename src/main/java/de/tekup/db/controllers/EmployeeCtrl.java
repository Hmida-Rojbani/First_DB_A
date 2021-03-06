package de.tekup.db.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.services.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeCtrl {
	
	private EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveEmp(@RequestBody EmployeeEntity employee) {
		return empService.saveToDB(employee);
	}
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getEmpByID(@PathVariable("id") int id) {
		return empService.getEmpById(id);
	}
	
	@GetMapping("/employee/get/name/{name}")
	public EmployeeEntity getEmpByName(@PathVariable("name") String name) {
		return empService.getEmpByName(name);
	}
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllEmp() {
		return empService.getAllEmployees();
	}
	
	@PutMapping("/employee/update/{id}")
	public EmployeeEntity updateEmpByID(@PathVariable("id") int id
						,@RequestBody EmployeeEntity employee) {
		return empService.updateEmp(employee, id);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public EmployeeEntity deleteEmpByID(@PathVariable("id") int id) {
		return empService.deleteEmpById(id);
	}
	

}

package de.tekup.db.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Error in Employee : "+e.getMessage());
	}

}

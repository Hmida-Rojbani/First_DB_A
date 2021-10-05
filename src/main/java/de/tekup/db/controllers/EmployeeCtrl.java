package de.tekup.db.controllers;

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

}

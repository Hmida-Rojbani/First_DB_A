package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.EmployeeRepository;
import de.tekup.db.repositories.MatriculeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {

	private EmployeeRepository empRepos;
	private MatriculeRepository matRepos;

	// SQL : insert
	public EmployeeEntity saveToDB(EmployeeEntity entity) {
		//Matricule matricule = entity.getMatricule();
		//matRepos.save(matricule);
		//entity.setMatricule(matricule);
		return empRepos.save(entity);
	}

	// SQL : select * from employee where id = id
	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> opt = empRepos.findById(id);
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee id not found");

		return opt.orElseThrow(() -> new NoSuchElementException("Employee id not found"));
	}

	// SQL : select * from employee
	public List<EmployeeEntity> getAllEmployees() {
		return empRepos.findAll();
	}

	// SQL : select * from employee where name = name
	public EmployeeEntity getEmpByName(String name) {
		return empRepos.findByNameIgnoreCase(name)
				.orElseThrow(() -> new NoSuchElementException("Employee name not found"));
	}
	
	//SQL : update 
	public EmployeeEntity updateEmp(EmployeeEntity newEmployee, int id) {
		EmployeeEntity employee = getEmpById(id);
		if(newEmployee.getName()!=null)
			employee.setName(newEmployee.getName());
		if(newEmployee.getDob()!=null)
			employee.setDob(newEmployee.getDob());
		if(newEmployee.getEmail()!=null)
			employee.setEmail(newEmployee.getEmail());
		return empRepos.save(employee);
	}
	
	//SQL :Delete
	public EmployeeEntity deleteEmpById(int id) {
		EmployeeEntity employee=getEmpById(id);
		empRepos.deleteById(id);
		return employee;
	}
}

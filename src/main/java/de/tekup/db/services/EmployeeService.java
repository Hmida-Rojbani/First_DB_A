package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
	
	private EmployeeRepository empRepos;
	
	//SQL : insert
	public EmployeeEntity saveToDB(EmployeeEntity entity) {
		return empRepos.save(entity);
	}

	//SQL : select * from employee where id = id
	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> opt= empRepos.findById(id);
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee id not found");
		
		return opt.orElseThrow(()->new NoSuchElementException("Employee id not found"));
	}
	
	//SQL : select * from employee
	public List<EmployeeEntity> getAllEmployees(){
		return empRepos.findAll();
	}
}

package de.tekup.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}

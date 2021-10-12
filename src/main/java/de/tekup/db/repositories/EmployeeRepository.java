package de.tekup.db.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	Optional<EmployeeEntity> findByName(String name);

	Optional<EmployeeEntity> findByNameIgnoreCase(String name);

}

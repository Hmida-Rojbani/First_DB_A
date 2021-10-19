package de.tekup.db.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.db.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	@Query("Select p from Project p where p.endDate >= :date")
	List<Project> getOpenProjects(@Param("date") LocalDate now);

}

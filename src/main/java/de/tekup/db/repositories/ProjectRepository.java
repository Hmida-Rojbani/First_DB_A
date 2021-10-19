package de.tekup.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}

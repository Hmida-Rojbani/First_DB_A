package de.tekup.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

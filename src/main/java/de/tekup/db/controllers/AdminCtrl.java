package de.tekup.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.Admin;
import de.tekup.db.services.AdminService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AdminCtrl {
	
	private AdminService adminService;
	
	@PostMapping("/admins")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.saveToDB(admin);
	}
	
	@GetMapping("/admins")
	public List<Admin> getAll(){
		return adminService.getAllAdmins();
	}
	

}

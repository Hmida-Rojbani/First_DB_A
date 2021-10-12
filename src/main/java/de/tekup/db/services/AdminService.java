package de.tekup.db.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.AdminRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private AdminRepository adminRepos;
	
	public Admin saveToDB(Admin admin) {
		adminRepos.save(admin);
		
//		for (Matricule mat : admin.getMatricules()) {
//			mat.setCreator(admin);
//		}
		
		admin.getMatricules().forEach(mat->mat.setCreator(admin));
		
		return adminRepos.save(admin);
	}
	
	public List<Admin> getAllAdmins(){
		return adminRepos.findAll();
	}

}

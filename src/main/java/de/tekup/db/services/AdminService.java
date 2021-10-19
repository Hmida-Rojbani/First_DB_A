package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.AdminRepository;
import de.tekup.db.repositories.MatriculeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private AdminRepository adminRepos;
	private MatriculeRepository matRepos;
	
	public Admin saveToDB(Admin admin) {
		adminRepos.save(admin);
		
//		for (Matricule mat : admin.getMatricules()) {
//			mat.setCreator(admin);
//		}
		if(admin.getMatricules()!=null)
			admin.getMatricules().forEach(mat->mat.setCreator(admin));
		
		return adminRepos.save(admin);
	}
	
	public List<Admin> getAllAdmins(){
		return adminRepos.findAll();
	}
	
	public Admin getAdminById(int id){
		return adminRepos.findById(id)
		.orElseThrow(()-> new NoSuchElementException("Admin id not found"));
	}
	
	// add of matricule to an admin 
	//locate admin by id
	// admin ->  list of matricule
	// new matricule contain the admin reference 
	// add new matricule to that list
	// save Matricule
	
	public Matricule addMatriculeToAdmin(int id, Matricule matricule) {
		Admin admin = getAdminById(id);
		matricule.setCreator(admin);
		admin.getMatricules().add(matricule);
		matRepos.save(matricule);
		return matricule;
	}
}

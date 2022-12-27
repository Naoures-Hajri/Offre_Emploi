package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.AdminRepository;
import com.designet.entities.Admin;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired  
    AdminRepository adminRepository;
    
    
	public Admin ajouterAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}

	public Admin modifierAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}

	public List<Admin> listAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	public void supprimerById(Long id) {
		adminRepository.deleteById(id);
		
	}

	public Optional<Admin> getAdminById(Long id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id);
	}


}

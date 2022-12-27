package com.designet.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import com.designet.entities.Admin;

public interface AdminService {
    Admin ajouterAdmin(Admin admin);
    Admin modifierAdmin(Admin admin);
    List<Admin>listAdmin();
    void supprimerById(Long id);
    Optional<Admin>  getAdminById(Long id);

}

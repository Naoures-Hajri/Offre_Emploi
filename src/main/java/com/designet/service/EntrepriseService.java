package com.designet.service;

import java.util.List;
import java.util.Optional;

import com.designet.entities.Entreprise;

public interface EntrepriseService {
    Entreprise ajouterEntreprise(Entreprise entreprise);
    Entreprise modifierEntreprise(Entreprise entreprise);
    List<Entreprise>listEntreprise();
    void supprimerById(Long id);
    Optional<Entreprise>  getEntrepriseById(Long id);

}

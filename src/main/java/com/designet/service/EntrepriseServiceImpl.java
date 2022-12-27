package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.EntrepriseRepository;
import com.designet.entities.Entreprise;
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRep;
	@Override
	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return entrepriseRep.save(entreprise);
	}

	@Override
	public Entreprise modifierEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return entrepriseRep.save(entreprise);
	}

	@Override
	public List<Entreprise> listEntreprise() {
		// TODO Auto-generated method stub
		return entrepriseRep.findAll();
	}

	@Override
	public void supprimerById(Long id) {
		// TODO Auto-generated method stub
		entrepriseRep.deleteById(id);
		
	}

	@Override
	public Optional<Entreprise> getEntrepriseById(Long id) {
		// TODO Auto-generated method stub
		return entrepriseRep.findById(id);
	}

}

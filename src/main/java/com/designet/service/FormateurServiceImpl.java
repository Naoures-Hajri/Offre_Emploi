package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.FormateurRepository;
import com.designet.entities.Formateur;
@Service
public class FormateurServiceImpl implements FormateurService {
	  @Autowired  
	    FormateurRepository formateurRepository;
	@Override
	public Formateur ajouterFormateur(Formateur formateur) {
		// TODO Auto-generated method stub
		return formateurRepository.save(formateur);
	}

	@Override
	public Formateur modifierFormateur(Formateur formateur) {
		// TODO Auto-generated method stub
		return formateurRepository.save(formateur);
	}

	@Override
	public List<Formateur> listFormateur() {
		// TODO Auto-generated method stub
		return formateurRepository.findAll();
	}

	@Override
	public void supprimerById(Long id) {
		formateurRepository.deleteById(id);
		
	}

	@Override
	public Optional<Formateur> getFormateurById(Long id) {
		// TODO Auto-generated method stub
		return formateurRepository.findById(id);
	}

}

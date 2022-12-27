package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.FormateurRepository;
import com.designet.Repository.OffreRepository;
import com.designet.Repository.PostulationRepository;
import com.designet.entities.Formateur;
import com.designet.entities.Offre;
import com.designet.entities.Postulation;
import com.designet.entitiesDTO.PostulationDTO;
@Service
public class PostulationServiceImpl implements PostulationService {
   @Autowired
   PostulationRepository postulationRep;
   @Autowired
   FormateurRepository formateurRep;
   @Autowired 
   OffreRepository offreRep;
   
	@Override
	public Postulation ajouterPostulation(PostulationDTO postulation) {
		System.out.println(postulation.getFormateurId());
		System.out.println(postulation.getOffreId());
	Optional<Formateur>formateur=formateurRep.findById(postulation.getFormateurId());
	
	Optional<Offre>offre=offreRep.findById(postulation.getOffreId());
	
	if(formateur.isPresent()&& offre.isPresent()) {
		if(!this.postulationRep.existsByFormateurIdAndOffreId(postulation.getFormateurId(), postulation.getOffreId())) 
			return postulationRep.save(new Postulation(formateur.get(), offre.get(), postulation.getCv()));
			else return null;
		}
	
	else return null;
	}

	@Override
	public List<Postulation> listPostulationByFormateur(Long id) {

		return postulationRep.findByFormateurId(id);
	}

	@Override
	public List<Postulation> listPostulationByOffre(Long id) {

		return postulationRep.findByOffreId(id);
	}

}

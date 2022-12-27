package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.OffreRepository;
import com.designet.entities.Entreprise;
import com.designet.entities.Offre;
import com.designet.entitiesDTO.OffreDto;

@Service
public class OffreServiceImpl implements OffreService {
	@Autowired
	OffreRepository offreRep;
	@Autowired
	EntrepriseService entrepriseRep;
	@Override
	public Offre ajouterOffre(Offre offre) {
       return offreRep.save(offre);
	}

	@Override
	public Offre modifierOffre(Offre offre) {
		System.out.println("update"+offre);
        Offre offre1=getOffreById(offre.getId());
        offre1.setDateFin(offre.getDateFin());
        offre1.setDatePub(offre.getDatePub());
        offre1.setDescription(offre.getDescription());
        offre1.setEtat(offre.isEtat());
        offre1.setGenre(offre.getGenre());
        offre1.setLangue(offre.getLangue());
        offre1.setLocalisation(offre.getLocalisation());
        offre1.setLogo(offre.getLogo());
        offre1.setNiveau(offre1.getNiveau());
        offre1.setNbrPers(offre.getNbrPers());
        offre1.setSite(offre.getSite());
        offre1.setTitre(offre.getTitre());
        offre1.setEntreprise(offre.getEntreprise());
		return offre1;
	}



	@Override
	public void supprimerById(Long id) {
		// TODO Auto-generated method stub
		offreRep.deleteById(id);
	}

	@Override
    public Offre getOffreById(Long id) {
        
        return offreRep.findById(id).get();
    }

	@Override
	public List<Offre> listOffre() {
		// TODO Auto-generated method stub
		return offreRep.findAll();
	}

	@Override
	public List<Offre> listOffreAccept() {
		// TODO Auto-generated method stub
		return offreRep.findOffreAccept();
	}

	@Override
	public List<Offre> listeoffreByEntId(Long id) {
		// TODO Auto-generated method stub
		return offreRep.findByEntrepriseId(id);
	}

	@Override
	public List<Offre> getOffreByEtat(Boolean etat) {
		// TODO Auto-generated method stub
		return offreRep.findByEtat(etat);
	}

}

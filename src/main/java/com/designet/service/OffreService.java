package com.designet.service;


import java.util.List;
import java.util.Optional;

import com.designet.entities.Offre;
import com.designet.entitiesDTO.OffreDto;

public interface OffreService {
	Offre ajouterOffre(Offre offre);
	Offre modifierOffre(Offre offre);
    List<Offre>listOffre();
    void supprimerById(Long id);
    Offre getOffreById(Long id);
    List<Offre>listOffreAccept();
    List<Offre> listeoffreByEntId(Long id);
    List<Offre> getOffreByEtat(Boolean etat);
    
}

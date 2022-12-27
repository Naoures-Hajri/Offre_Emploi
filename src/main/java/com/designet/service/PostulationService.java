package com.designet.service;

import java.util.List;

import com.designet.entities.Postulation;
import com.designet.entitiesDTO.PostulationDTO;

public interface PostulationService {
	Postulation ajouterPostulation(PostulationDTO postulation);
	List<Postulation> listPostulationByFormateur(Long id);
	List<Postulation> listPostulationByOffre(Long id);

}

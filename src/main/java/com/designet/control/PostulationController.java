package com.designet.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.designet.entities.Postulation;
import com.designet.entitiesDTO.PostulationDTO;
import com.designet.service.PostulationService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/postulation")
public class PostulationController {
	@Autowired
	PostulationService postulationService;
	
	@RequestMapping(method = RequestMethod.POST)
    public Postulation ajouterPostulation(@RequestBody PostulationDTO postulation){
		return (Postulation)postulationService.ajouterPostulation(postulation);
	}
	@GetMapping("/listePostulationFormateur/{id}")
	public List<Postulation> listePostulationFormateur(@PathVariable Long id){
		return postulationService.listPostulationByFormateur(id);	
	}
	@GetMapping("/listePostulationOffre/{id}")
	public List<Postulation> listePostulationOffre(@PathVariable Long id){
		return postulationService.listPostulationByOffre(id);	
	}

}

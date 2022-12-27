package com.designet.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.designet.Repository.EntrepriseRepository;
import com.designet.entities.Entreprise;
import com.designet.entities.Offre;
import com.designet.entitiesDTO.OffreDto;
import com.designet.service.OffreService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/offre")
public class OffreController {
	@Autowired
	OffreService offreService;
	@Autowired
	EntrepriseRepository entrepriseRep;
	@Autowired
	private ModelMapper modelmapper;
	 @RequestMapping(method = RequestMethod.POST)
	    public OffreDto ajouterOffre(@RequestBody OffreDto offreDto){
			/* Optional<Entreprise>entreprise=entrepriseRep.getEntrepriseById(offre.getEntrepriseId());
			if(entreprise.isPresent()) {
				Offre of=new Offre();
			of.setLogo(offre.getLogo());
			of.setTitre(offre.getTitre());
			of.setDateFin(of.getDateFin());
			of.setDatePub(offre.getDatePub());
			of.setDescription(offre.getDescription());
			of.setEtat(offre.isEtat());
			of.setGenre(offre.getGenre());
			of.setLangue(offre.getLangue());
			of.setLocalisation(offre.getLocalisation());
			of.setNbrPers(offre.getNbrPers());
			of.setNiveau(offre.getNiveau());
			of.setSite(offre.getSite());
			of.setEntreprise(entreprise.get());
			*/
		 Offre offreRequest=modelmapper.map(offreDto,Offre.class);
			Offre offre= offreService.ajouterOffre(offreRequest);
			OffreDto offreResponse=modelmapper.map(offre,OffreDto.class);
			return offreResponse;
		//} else {return null;}
	 }
	    

	    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	    public Offre modifierOffre(@PathVariable("id")Long id,@RequestBody Offre offre){
	    	Offre newOffre=offreService.modifierOffre(offre);
	        return newOffre;
	    }
	    @GetMapping("/get-id/{id}")
	    public Offre getOffreById(@PathVariable("id")Long id){
	      
	        return offreService.getOffreById(id);
	    }
	    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	    public void suprrimerOffre(@PathVariable("id")Long id){
	    	offreService.supprimerById(id);
	    }
	    @RequestMapping(method = RequestMethod.GET)
	    public List<OffreDto>listOffre(){
	    	return offreService.listOffre().stream().map(offres -> modelmapper.map(offres,OffreDto.class)).collect(Collectors.toList());
	    	//return offreService.listOffre();
	    }
	    @GetMapping("/offreAccept")
        public List<Offre>listOffreAccept(){
	    	
	        return offreService.listOffreAccept();
	    }
	    @GetMapping("list-offre-by-entreprise/{id}")
	    public List<Offre> listOffreByIdEnt(@PathVariable Long id) {
	    	return offreService.listeoffreByEntId(id);
	    }
	  
}

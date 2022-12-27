package com.designet.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.designet.Repository.FormateurRepository;
import com.designet.entities.Admin;
import com.designet.entities.Formateur;
import com.designet.service.FormateurService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("*")
@RequestMapping (value="/formateur")
public class FormateurController {
	@Autowired
	FormateurService formateurService;
	@Autowired
	private FormateurRepository formateurRep;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
	
	@Autowired
	 public FormateurController(FormateurRepository formateurRepository) {
    	this.formateurRep= formateurRepository;
    	}
	
	   @RequestMapping(method = RequestMethod.POST)
	    public Formateur ajouterFormateur(@RequestBody Formateur formateur){
	        return formateurService.ajouterFormateur(formateur);
	    }
	   
	   @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	    public Formateur modifierFormateur(@PathVariable("id")Long id,@RequestBody Formateur formateur){
	        Formateur newFormateur=formateurService.modifierFormateur(formateur);
	        return newFormateur;
	    }
	   
	    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
	    public Optional<Formateur>getFormateurById(@PathVariable("id")Long id){
	        Optional<Formateur>formateur=formateurService.getFormateurById(id);
	        return formateur;
	    }
	    
	    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	    public void suprrimerFormateur(@PathVariable("id")Long id){
	        formateurService.supprimerById(id);
	    }

	    @RequestMapping(method = RequestMethod.GET)
	    public List<Formateur>listFormateur(){
	        return formateurService.listFormateur();
	    }
	    
	    @PostMapping(path = "registerformateur")
	    public ResponseEntity<?> addFormateur(@RequestBody Formateur formateur) {
	        if(formateurRep.existsByEmail(formateur.getEmail()))
	            return new ResponseEntity<Void>(HttpStatus.FOUND);
	        formateur.setMdp(this.bCryptPasswordEncoder.encode(formateur.getMdp()));
	        Formateur savedUser = formateurRep.save(formateur);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	    }
	    
	    @PostMapping(path = "login")
	    public ResponseEntity<Map<String, Object>> loginFormateur(@RequestBody Formateur formateur) {

	        HashMap<String, Object> response = new HashMap<>();

	        Formateur userFromDB = formateurRep.findFormateurByEmail(formateur.getEmail());

	        if (userFromDB == null) {
	            response.put("message", "Formateur not found !");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }  else {
	            String token = Jwts.builder()
	                    .claim("data", userFromDB)
	                    .signWith(SignatureAlgorithm.HS256, "SECRET")
	                    .compact();
	            response.put("token", token);
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        }
	    }
}

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

import com.designet.Repository.EntrepriseRepository;
import com.designet.entities.Entreprise;
import com.designet.entities.Formateur;
import com.designet.service.EntrepriseService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/entreprise")
public class EntrepriseController {
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	private EntrepriseRepository entrepriseRep;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
	
	 @RequestMapping(method = RequestMethod.POST)
	    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise){
	        return entrepriseService.ajouterEntreprise(entreprise);
	    }

	    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	    public Entreprise modifierEntreprise(@PathVariable("id")Long id,@RequestBody Entreprise entreprise){
	    	Entreprise newEntreprise=entrepriseService.modifierEntreprise(entreprise);
	        return newEntreprise;
	    }
	 
	    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	    public void suprrimerEntreprise(@PathVariable("id")Long id){
	    	entrepriseService.supprimerById(id);
	    }
	    @RequestMapping(method = RequestMethod.GET)
	    public List<Entreprise>listEntreprise(){
	        return entrepriseService.listEntreprise();
	    }
	    @PostMapping(path = "registerentreprise")
	    public ResponseEntity<?> addEntreprise(@RequestBody Entreprise entreprise) {
	        if(entrepriseRep.existsByEmail(entreprise.getEmail()))
	            return new ResponseEntity<Void>(HttpStatus.FOUND);
	        entreprise.setMdp(this.bCryptPasswordEncoder.encode(entreprise.getMdp()));
	        Entreprise savedUser = entrepriseRep.save(entreprise);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	    }
	    
	    @PostMapping(path = "login")
	    public ResponseEntity<Map<String, Object>> loginEntreprie(@RequestBody Entreprise entreprise) {

	        HashMap<String, Object> response = new HashMap<>();

	        Entreprise userFromDB = entrepriseRep.findEntrepriseByEmail(entreprise.getEmail());

	        if (userFromDB == null) {
	            response.put("message", "Entreprise not found !");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        } else {

	            Boolean compare = this.bCryptPasswordEncoder.matches(entreprise.getMdp(), userFromDB.getMdp());

	            if (!compare) {
	                response.put("message", "Entreprise not found !");
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	            } else {
	                if (!userFromDB.isEtat()) {
	                    response.put("message", "Entreprise not allowed !");
	                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	                } else {
	            String token = Jwts.builder()
	                    .claim("data", userFromDB)
	                    .signWith(SignatureAlgorithm.HS256, "SECRET")
	                    .compact();
	            response.put("token", token);
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        }}
	    }}  
	    
	    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	    public Optional<Entreprise>getEnterpriseById(@PathVariable("id")Long id){
	        Optional<Entreprise>entreprise=entrepriseService.getEntrepriseById(id);
	        return entreprise;
	    }
}
	



package com.designet.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.designet.Repository.ContactRepository;

import com.designet.entities.Contact;
import com.designet.service.ContactService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/contact")
public class ContactController {
	@Autowired
	ContactService contactService;
	@Autowired
	ContactRepository contactRep;
	
	 @RequestMapping(method = RequestMethod.POST)
	    public Contact ajouterContact(@RequestBody Contact contact){
	        return contactService.ajouterContact(contact);
	    }

	    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	    public Contact modifierContact(@PathVariable("id")Long id,@RequestBody Contact contact){
	        Contact newContact=contactService.modifierContact(contact);
	        return newContact;
	    }
	    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
	    public Optional<Contact>getContactById(@PathVariable("id")Long id){
	        Optional<Contact>contact=contactService.getContactById(id);
	        return contact;
	    }
	    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	    public void suprrimerContact(@PathVariable("id")Long id){
	    	contactService.supprimerById(id);
	    }
	    @RequestMapping(method = RequestMethod.GET)
	    public List<Contact>listContact(){
	        return contactService.listContact();
	    }
}

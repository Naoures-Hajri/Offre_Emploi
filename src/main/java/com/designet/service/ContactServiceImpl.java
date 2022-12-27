package com.designet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designet.Repository.ContactRepository;
import com.designet.entities.Contact;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired 
	ContactRepository contactRep;
	@Override
	public Contact ajouterContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRep.save(contact);
	}

	@Override
	public Contact modifierContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRep.save(contact);
	}

	@Override
	public List<Contact> listContact() {
		// TODO Auto-generated method stub
		return contactRep.findAll();
	}

	@Override
	public void supprimerById(Long id) {
		// TODO Auto-generated method stub
		contactRep.deleteById(id);
		
	}

	@Override
	public Optional<Contact> getContactById(Long id) {
		// TODO Auto-generated method stub
		return contactRep.findById(id);
	}

}

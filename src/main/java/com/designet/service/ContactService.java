package com.designet.service;

import java.util.List;
import java.util.Optional;

import com.designet.entities.Contact;


public interface ContactService {
    Contact ajouterContact(Contact contact);
    Contact modifierContact(Contact contact);
    List<Contact>listContact();
    void supprimerById(Long id);
    Optional<Contact>  getContactById(Long id);

}

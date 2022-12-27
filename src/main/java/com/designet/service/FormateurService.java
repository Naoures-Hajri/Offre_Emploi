package com.designet.service;

import java.util.List;
import java.util.Optional;

import com.designet.entities.Formateur;

public interface FormateurService {
    Formateur ajouterFormateur(Formateur formateur);
    Formateur modifierFormateur(Formateur formateur);
    List<Formateur>listFormateur();
    void supprimerById(Long id);
    Optional<Formateur>  getFormateurById(Long id);

}

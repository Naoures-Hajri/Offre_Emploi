package com.designet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nom;
	    private String email;
	    private String sujet;
	    private String message;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSujet() {
			return sujet;
		}
		public void setSujet(String sujet) {
			this.sujet = sujet;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Contact(Long id, String nom, String email, String sujet, String message) {
			super();
			this.id = id;
			this.nom = nom;
			this.email = email;
			this.sujet = sujet;
			this.message = message;
		}
		public Contact() {
			super();
		}
	    
}

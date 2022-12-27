package com.designet.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="postulation")
@ToString
public class Postulation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Lob
	 private String cv;
	 @OneToOne
	 private Formateur formateur;
	 @OneToOne
	 private Offre offre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	public Postulation(Formateur formateur, Offre offre, String cv) {
		
		this.formateur = formateur;
		this.offre = offre;
		this.cv = cv;
	}
	public Postulation() {
		super();
	}
	

	 
	 
}

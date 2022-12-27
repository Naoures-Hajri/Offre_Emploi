package com.designet.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    @Lob
    private String logo;

    private String datePub;
  
    private String dateFin;
    private int nbrPers;
    private boolean etat=false;
    private int salaire;
    private String site;
    private String localisation;
    private String langue;
    private String niveau;
    private String genre;
    @JsonIgnore
	@ManyToOne
      @JoinColumn(name="FK_ENTRPRISE_ID")
	private Entreprise entreprise;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDatePub() {
		return datePub;
	}
	public void setDatePub(String datePub) {
		this.datePub = datePub;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbrPers() {
		return nbrPers;
	}
	public void setNbrPers(int nbrPers) {
		this.nbrPers = nbrPers;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Offre(Long id, String titre, String description, String logo, String datePub, String dateFin, int nbrPers,
			boolean etat, int salaire, String site, String localisation, String langue, String niveau, String genre,
			Entreprise entreprise) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.logo = logo;
		this.datePub = datePub;
		this.dateFin = dateFin;
		this.nbrPers = nbrPers;
		this.etat = etat;
		this.salaire = salaire;
		this.site = site;
		this.localisation = localisation;
		this.langue = langue;
		this.niveau = niveau;
		this.genre = genre;
		this.entreprise = entreprise;
	}
	public Offre() {
		super();
	}
    
    

	

	
}

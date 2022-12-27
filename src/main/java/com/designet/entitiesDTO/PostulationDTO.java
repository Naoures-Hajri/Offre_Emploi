package com.designet.entitiesDTO;

import javax.persistence.Lob;

public class PostulationDTO {
private Long formateurId;
private Long offreId;
@Lob
private String cv;
public Long getFormateurId() {
	return formateurId;
}
public void setFormateurId(Long formateurId) {
	this.formateurId = formateurId;
}
public Long getOffreId() {
	return offreId;
}
public void setOffreId(Long offreId) {
	this.offreId = offreId;
}
public String getCv() {
	return cv;
}
public void setCv(String cv) {
	this.cv = cv;
}
public PostulationDTO(Long formateurId, Long offreId, String cv) {
	super();
	this.formateurId = formateurId;
	this.offreId = offreId;
	this.cv = cv;
}
public PostulationDTO() {
	super();
}

}

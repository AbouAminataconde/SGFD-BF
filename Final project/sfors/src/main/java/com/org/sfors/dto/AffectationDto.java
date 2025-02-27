package com.org.sfors.dto;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AffectationDto extends ResponseDto{
	
	private String uuid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateAffectation;
	
	private String  uuidFormateur;
	private String  nomFormateur;
	private String  prenomFormateur;
	
	private String  uuidFormation;
	private String libelleFormation;
	private String descriptionFormation;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public String getUuidFormateur() {
		return uuidFormateur;
	}
	public void setUuidFormateur(String uuidFormateur) {
		this.uuidFormateur = uuidFormateur;
	}
	public String getNomFormateur() {
		return nomFormateur;
	}
	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}
	public String getPrenomFormateur() {
		return prenomFormateur;
	}
	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}
	public String getUuidFormation() {
		return uuidFormation;
	}
	public void setUuidFormation(String uuidFormation) {
		this.uuidFormation = uuidFormation;
	}
	public String getLibelleFormation() {
		return libelleFormation;
	}
	public void setLibelleFormation(String libelleFormation) {
		this.libelleFormation = libelleFormation;
	}
	public String getDescriptionFormation() {
		return descriptionFormation;
	}
	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}
	
	
	
	
	

}

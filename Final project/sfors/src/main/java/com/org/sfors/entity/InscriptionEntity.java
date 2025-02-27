package com.org.sfors.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.org.sfors.enums.EnumGenre;

@Entity
@Table(name = "inscription")
public class InscriptionEntity extends AbstractEntity{
	
	@Column(nullable = false)
	private String entrepriseName;
	@Column( nullable = false)
	private String codeNif;
	@Column(unique=false, nullable = false)
	private String codeRccm;
	@Column(unique=false, nullable = true)
	private String codeDeclarant;
	@Column(unique=false, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String nom;
	@Column( nullable = false)
	private String prenoms;
	@Column(unique=true, nullable = false)
	private String telephone;
	@Column(nullable = false)
	private EnumGenre sexe;
	@Column(nullable = false)
	private String adress;
	@Column(nullable = true)
	private String status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateInscription;
	
	/*@ManyToOne
	private FormationEntity formation;*/
	
	@ManyToOne
	private PublicationEntity publication;

	public String getEntrepriseName() {
		return entrepriseName;
	}

	public void setEntrepriseName(String entrepriseName) {
		this.entrepriseName = entrepriseName;
	}

	public String getCodeNif() {
		return codeNif;
	}

	public void setCodeNif(String codeNif) {
		this.codeNif = codeNif;
	}

	public String getCodeRccm() {
		return codeRccm;
	}

	public void setCodeRccm(String codeRccm) {
		this.codeRccm = codeRccm;
	}

	public String getCodeDeclarant() {
		return codeDeclarant;
	}

	public void setCodeDeclarant(String codeDeclarant) {
		this.codeDeclarant = codeDeclarant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public EnumGenre getSexe() {
		return sexe;
	}

	public void setSexe(EnumGenre sexe) {
		this.sexe = sexe;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public PublicationEntity getPublication() {
		return publication;
	}

	public void setPublication(PublicationEntity publication) {
		this.publication = publication;
	}

	/*public FormationEntity getFormation() {
		return formation;
	}

	public void setFormation(FormationEntity formation) {
		this.formation = formation;
	}*/

	

	

	
}

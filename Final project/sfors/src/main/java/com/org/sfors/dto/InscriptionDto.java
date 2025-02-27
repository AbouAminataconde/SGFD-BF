package com.org.sfors.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.org.sfors.enums.EnumGenre;

public class InscriptionDto extends ResponseDto{
	
	private String uuid;
	private String entrepriseName;
	private String codeNif;
	private String codeRccm;
	private String codeDeclarant;
	private String email;
	
	private String nom;
	private String prenoms;
	private String telephone;
	private EnumGenre sexe;
	private String adress;
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateInscription;
	
	private String  uuidPublication;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datePublication;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFin;
	
	private String  lebelleFormation;
	private String  descriptionFormation;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
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
	public String getUuidPublication() {
		return uuidPublication;
	}
	public void setUuidPublication(String uuidPublication) {
		this.uuidPublication = uuidPublication;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getLebelleFormation() {
		return lebelleFormation;
	}
	public void setLebelleFormation(String lebelleFormation) {
		this.lebelleFormation = lebelleFormation;
	}
	public String getDescriptionFormation() {
		return descriptionFormation;
	}
	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}
	
	

	
}

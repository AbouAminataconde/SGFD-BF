package com.org.sfors.dto;

import com.org.sfors.enums.EnumGenre;

public class FormateurDto extends ResponseDto{
	
	private String uuid;
	private String nom;
	private String prenoms;
	private EnumGenre sexe;
	private String phone;
	private String email;
	private String profession;
	private String adress;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public EnumGenre getSexe() {
		return sexe;
	}
	public void setSexe(EnumGenre sexe) {
		this.sexe = sexe;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	
	
	

}

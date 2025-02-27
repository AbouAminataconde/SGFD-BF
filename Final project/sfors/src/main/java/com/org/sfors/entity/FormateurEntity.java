package com.org.sfors.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.org.sfors.enums.EnumGenre;


@Entity
@Table(name = "formateur")
public class FormateurEntity extends AbstractEntity{
	
	
	private String nom;
	private String prenoms;
	private EnumGenre sexe;
	@Column(unique = true)
	private String phone;
	@Column(unique = true)
	private String email;
	private String profession;
	private String adress;
	
	@OneToMany(mappedBy = "formateur")
	List<AffectationEntity> affectationList;
	
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
	public List<AffectationEntity> getAffectationList() {
		return affectationList;
	}
	public void setAffectationList(List<AffectationEntity> affectationList) {
		this.affectationList = affectationList;
	}
	

}
